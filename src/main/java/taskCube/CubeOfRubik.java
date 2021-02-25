package taskCube;

import java.util.Random;

/**
 * @author Polina Postylyakova (poletela-na-mars)
 */

public class CubeOfRubik {

    public enum sides {
        U(0), L(1), F(2), R(3), B(4), D(5);

        private final int numberOfSide;

        sides(int numberOfSide) {
            this.numberOfSide = numberOfSide;
        }
        private int getNumberOfSide(){
            return numberOfSide;
        }
    }

    public enum Cube {
        RED('R'), WHITE('W'), GREEN('G'), YELLOW('Y'), ORANGE('O'), BLUE('B');

        private final char colour;

        Cube(char colour) {
            this.colour = colour;
        }
        private char getColour(){
            return colour;
        }
    }

    public Cube[][][] specification;       // [грани = 6][строка][столбец]

    private final int sizeOfCube;

    /**
     * Определяем кубик Рубика. Записываем его конфигурацию в трехмерный массив. Учитываем выбор размера кубика.
     */

    CubeOfRubik(int sizeOfCube) {
        if (sizeOfCube < 2) {
            throw new IllegalArgumentException("Некорректный размер кубика");
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

    public enum direction {
        right('r'), left('l');

        private final char dir;

        direction(char dir) {
            this.dir = dir;
        }
        private int getDirection(){
            return dir;
        }
    }

    /**
     * Поворот грани вправо (по часовой стрелке)/влево (против часовой стрелки).
     */

    void rotateSide(sides side, direction dir) {
        Cube[][] mark = new Cube[sizeOfCube][sizeOfCube];
        for (int i = 0; i < sizeOfCube; i++) {
            for (int j = 0; j < sizeOfCube; j++) {
                mark[i][j] = specification[side.getNumberOfSide()][i][j];
            }
        }
        if (dir.getDirection() == 'r') {
            for (int x = 0; x < sizeOfCube; x++) {
                for (int y = 0; y < sizeOfCube; y++) {
                    specification[side.getNumberOfSide()][x][y] = mark[y][sizeOfCube - x - 1];
                }
            }
        }
        if (dir.getDirection() == 'l') {
            for (int x = 0; x < sizeOfCube; x++) {
                for (int y = 0; y < sizeOfCube; y++) {
                    specification[side.getNumberOfSide()][x][y] = mark[sizeOfCube - y - 1][x];
                }
            }
        }
    }

    /**
     * Поворот слоя вправо (по часовой стрелке).
     */

    void rotateLayerRight(int layer) {
        if (layer > sizeOfCube - 1 || layer < 0) {
            throw new IllegalArgumentException("Некорректный номер слоя");
        }
        if (layer == 0) {
            rotateSide(sides.U, direction.right);
        } else if (layer + 1 == sizeOfCube) {
            rotateSide(sides.D, direction.left);
            // влево, поскольку, выбирая направление поворота,
            // мы условно смотрим на грань, которую поворачиваем
        }
        Cube[] eq = specification[sides.B.getNumberOfSide()][layer];
        specification[sides.B.getNumberOfSide()][layer] = specification[sides.R.getNumberOfSide()][layer];
        specification[sides.R.getNumberOfSide()][layer] = specification[sides.F.getNumberOfSide()][layer];
        specification[sides.F.getNumberOfSide()][layer] = specification[sides.L.getNumberOfSide()][layer];
        specification[sides.L.getNumberOfSide()][layer] = eq;
    }

    /**
     * Поворот слоя влево (против часовой стрелки).
     * Для уменьшения объема кода повторим трижды метод для поворота слоя вправо --> эффект тот же.
     */

    void rotateLayerLeft(int layer) {
        for (int i = 0; i < 3; i++) {
            rotateLayerRight(layer);
        }
    }

    /**
     * Метод поворота указанного числа слоя вправо (по часовой стрелке)/влево (против часовой стрелки).
     */

    void numberRotateLayer(int number, int layer, direction dir) {
        if (number < 0) {
            throw new IllegalArgumentException("Некорректное число поворотов слоя");
        }
        if (dir.getDirection() == 'r') {
            for (int i = 0; i < number; i++) {
                rotateLayerRight(layer);
            }
        }
        if (dir.getDirection() == 'l') {
            for (int i = 0; i < number; i++) {
                rotateLayerLeft(layer);
            }
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
        Cube[][] eq = specification[sides.F.getNumberOfSide()];
        specification[sides.F.getNumberOfSide()] = specification[sides.D.getNumberOfSide()];
        specification[sides.D.getNumberOfSide()] = specification[sides.B.getNumberOfSide()];
        specification[sides.B.getNumberOfSide()] = specification[sides.U.getNumberOfSide()];
        specification[sides.U.getNumberOfSide()] = eq;
        rotateSide(sides.R, direction.left);
        rotateSide(sides.L, direction.right);
    }

    /**
     * Поворот всего куба от себя.
     */

    private void rotateCubeDown() {
        Cube[][] eq = specification[sides.F.getNumberOfSide()];
        specification[sides.F.getNumberOfSide()] = specification[sides.U.getNumberOfSide()];
        specification[sides.U.getNumberOfSide()] = specification[sides.B.getNumberOfSide()];
        specification[sides.B.getNumberOfSide()] = specification[sides.D.getNumberOfSide()];
        specification[sides.D.getNumberOfSide()] = eq;
        rotateSide(sides.L, direction.left);
        rotateSide(sides.R, direction.right);
    }

    /**
     * Запрос состояния грани. Для упрощения восприятия и визуализации представлен в строковой форме.
     */

    public String toStringSpec(int side) {
        StringBuilder strBuilder = new StringBuilder();
        for (int x = 0; x < sizeOfCube; x++) {
            for (int y = 0; y < sizeOfCube; y++) {
                strBuilder.append(specification[side][x][y].getColour());
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

    void turnToUpSide(sides side) {
        switch (side) {
            case U -> {     //  игнорируем попытку сделать верхнюю грань верхней
            }
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
     * Это производится с помощью класса Random.
     */

    int rand() {
        int min = 0;
        int max = 3;
        int diff = max - min;
        Random random = new Random();
        return random.nextInt(diff + 1);
    }

    public void randomInst() {
        for (int i = 1; i < 3 + rand(); i++) {
            for (int j = 0; j < rand(); j++) {
                rotateLayerRight(0);
                rotateSide(sides.D, direction.right);
                rotateSide(sides.R, direction.left);
            }
            for (int j = 0; j < rand(); j++) {
                rotateLayerRight(sizeOfCube - 1);
                rotateSide(sides.L, direction.right);
                rotateSide(sides.U, direction.left);
            }
            for (int j = 0; j < rand(); j++) {
                rotateLayerRight(sizeOfCube - 2);
                rotateSide(sides.F, direction.right);
                rotateSide(sides.B, direction.left);
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
                    strBuilder.append(specification[s][x][y].getColour());
                    strBuilder.append("  ");
                }
                strBuilder.append("   ");
            }
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }
}





