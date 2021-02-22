package taskCube;

import java.util.Map;

/**
 * @author Polina Postylyakova (poletela-na-mars)
 */

public class CubeOfRubik {

    private final static int U = 0;
    private final static int L = 1;
    private final static int F = 2;
    private final static int R = 3;
    private final static int B = 4;
    private final static int D = 5;

    public enum Cube {
        RED, WHITE, GREEN, YELLOW, ORANGE, BLUE
    }

    private final static Map<Cube, Character> Colour = Map.of(
            Cube.RED, 'R',
            Cube.WHITE, 'W',
            Cube.GREEN, 'G',
            Cube.YELLOW, 'Y',
            Cube.ORANGE, 'O',
            Cube.BLUE, 'B'
    );

    public Cube[][][] specification;       // [грани = 6][строка][столбец]

    private final int sizeOfCube;

    /**
     * Определяем кубик Рубика. Записываем его конфигурацию в трехмерный массив. Учитываем выбор размера кубика.
     */

    CubeOfRubik(int sizeOfCube) {
        if (sizeOfCube < 2) {
            throw new IllegalArgumentException();
        }
        this.sizeOfCube = sizeOfCube;
        this.specification = new Cube[6][sizeOfCube][sizeOfCube];
        for (int s = 0; s < 6; s++) {
            for (int x = 0; x < sizeOfCube; x++) {
                for (int y = 0; y < sizeOfCube; y++) {
                    this.specification[s][x][y] = Cube.values()[s];
                }
            }
        }
    }

    /**
     * Как правило поворот стороны кубика связывают с понятиями "по часовой стрелке", "против часовой стрелки",
     * однако мы для удобства будем апеллировать к обычным терминам "влево", "вправо", а также "вверх" и "вниз".
     */

    /**
     * Поворот грани вправо (по часовой стрелке).
     */

    void rotateSideRight(int side) {
        if (side > 5 || side < 0) {             // 6 граней у любого куба;
            throw new IllegalArgumentException();
        }
        Cube[][] mark = new Cube[sizeOfCube][sizeOfCube];
        for (int i = 0; i < sizeOfCube; i++) {
            for (int j = 0; j < sizeOfCube; j++) {
                mark[i][j] = specification[side][i][j];
            }
        }
        for (int x = 0; x < sizeOfCube; x++) {
            for (int y = 0; y < sizeOfCube; y++) {
                specification[side][x][y] = mark[y][sizeOfCube - x - 1];
            }
        }
    }

    /**
     * Поворот грани влево (против часовой стрелки).
     */

    void rotateSideLeft(int side) {
        if (side > 5 || side < 0) {
            throw new IllegalArgumentException();
        }
        Cube[][] mark = new Cube[sizeOfCube][sizeOfCube];
        for (int i = 0; i < sizeOfCube; i++) {
            for (int j = 0; j < sizeOfCube; j++) {
                mark[i][j] = specification[side][i][j];
            }
        }
        for (int x = 0; x < sizeOfCube; x++) {
            for (int y = 0; y < sizeOfCube; y++) {
                specification[side][x][y] = mark[sizeOfCube - y - 1][x];
            }
        }
    }

    /**
     * Поворот слоя вправо (по часовой стрелке).
     */

    void rotateLayerRight(int layer) {
        if (layer > sizeOfCube - 1 || layer < 0) {
            throw new IllegalArgumentException();
        }
        if (layer == 0) {
            rotateSideRight(U);
        } else if (layer + 1 == sizeOfCube) {
            rotateSideLeft(D);
            // влево, поскольку, выбирая направление поворота,
            // мы условно смотрим на грань, которую поворачиваем
        }
        Cube[] eq = specification[B][layer];
        specification[B][layer] = specification[R][layer];
        specification[R][layer] = specification[F][layer];
        specification[F][layer] = specification[L][layer];
        specification[L][layer] = eq;
    }

    /**
     * Поворот слоя влево (против часовой стрелки).
     * Для уменьшения объема кода повторим трижды метод для поворота слоя вправо --> эффект тот же.
     */

    void rotateLayerLeft(int layer) {
        if (layer > sizeOfCube - 1 || layer < 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            rotateLayerRight(layer);
        }
    }

    /**
     * Методы поворота указанного числа слоя.
     */

    void numberRotateLayerRight(int number, int layer) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < number; i++) {
            rotateLayerRight(layer);
        }
    }

    void numberRotateLayerLeft(int number, int layer) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < number; i++) {
            rotateLayerLeft(layer);
        }
    }

    /**
     * Поворот всего куба вправо (по часовой стрелке), переименование граней. Он выполняется поворотом всех слоев вправо.
     */

    private void rotateCubeRight() {
        for (int i = 0; i < sizeOfCube; i++) {
            rotateLayerRight(i);
        }
    }

    /**
     * Поворот всего куба влево (против часовой стрелки), переименование граней. Он выполняется поворотом всех слоев влево.
     */

    private void rotateCubeLeft() {
        for (int i = 0; i < sizeOfCube; i++) {
            rotateLayerLeft(i);
        }
    }

    /**
     * Поворот всего куба на себя.
     */

    private void rotateCubeUp() {
        Cube[][] eq = specification[F];
        specification[F] = specification[D];
        specification[D] = specification[B];
        specification[B] = specification[U];
        specification[U] = eq;
        rotateSideLeft(R);
        rotateSideRight(L);
    }

    /**
     * Поворот всего куба от себя.
     */

    private void rotateCubeDown() {
        Cube[][] eq = specification[F];
        specification[F] = specification[U];
        specification[U] = specification[B];
        specification[B] = specification[D];
        specification[D] = eq;
        rotateSideLeft(L);
        rotateSideRight(R);
    }

    /**
     * Запрос состояния грани. Для упрощения восприятия и визуализации представлен в строковой форме.
     */

    public String toStringSpec(int side) {
        StringBuilder strBuilder = new StringBuilder();
        for (int x = 0; x < sizeOfCube; x++) {
            for (int y = 0; y < sizeOfCube; y++) {
                strBuilder.append(Colour.get(specification[side][x][y]));  // поиск по ключам
                strBuilder.append("  ");
            }
            strBuilder.append("   ");
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }

    /**
     * Установка выбранной грани в качестве верхней. Также подходит нам для тестирования многих вышеперечисленных методов.
     */

    void turnToUpSide(int side) {
        if (side == 0) {
            throw new IllegalArgumentException();
            // бессмысленно делать верхнюю грань верхней
        }
        switch (side) {
            case L -> {
                rotateCubeRight();
                rotateCubeUp();
            }
            case F -> rotateCubeUp();
            case R -> {
                rotateCubeLeft();
                rotateCubeUp();
            }
            case B -> rotateCubeDown();
            case D -> {
                rotateCubeUp();
                rotateCubeUp();
            }
            default -> {        //*break*
            }
        }
    }

    /**
     * Случайная установка состояния кубика. На профессиональном языке называется скрамбл или перемешка.
     * То есть определенная или случайная последовательность поворотов граней и/или слоев кубика, подготавливающая его к последующей сборке.
     * В нашем случае используется отчасти определенная последовательность и отчасти случайная, что позволяет добиться
     * достаточно корректного перемшивания кубика любого размера. Алгоритм, представленный ниже,
     * является абсолютно случайным, создан без использования каких-либо известных шаблонов.
     * Это производится с помощью метода Math.random().
     */

    public void randomInst() {
        int number = (int) (Math.random() * 3);  // [0; 3)
        for (int i = 1; i < 3 + number; i++) {
            int z = (int) (Math.random() * 3);
            for (int j = 0; j < z; j++) {
                rotateLayerRight(0);
                rotateSideRight(D);
                rotateSideLeft(R);
            }
            z = (int) (Math.random() * 3);
            for (int j = 0; j < z; j++) {
                rotateLayerRight(sizeOfCube - 1);
                rotateSideRight(L);
                rotateSideLeft(U);
            }
            z = (int) (Math.random() * 3);
            for (int j = 0; j < z; j++) {
                rotateLayerRight(sizeOfCube - 2);
                rotateSideRight(F);
                rotateSideLeft(B);
            }
        }
    }

    /**
     * Для визуализации и удобства в тестах будем использовать переопределенный метод toString().
     * Будем показывать состояния наших граней в общем с помощью этого метода (строковый).
     */

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        for (int x = 0; x < sizeOfCube; x++) {
            for (int s = 0; s < 6; s++) {
                for (int y = 0; y < sizeOfCube; y++) {
                    strBuilder.append(Colour.get(specification[s][x][y]));  // поиск по ключам
                    strBuilder.append("  ");
                }
                strBuilder.append("   ");
            }
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }
}





