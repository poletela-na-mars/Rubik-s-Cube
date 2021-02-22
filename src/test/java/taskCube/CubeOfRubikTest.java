package taskCube;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CubeOfRubikTest {
    int sizeOfCube;
    private static CubeOfRubik cube_1;
    /**
     * Строковое представление кубика в его начальном состоянии (3 на 3) (cube_1)
     * R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B
     * R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B
     * R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B
     */

    @Test
    public void rotateLayerRight() {
        sizeOfCube = 5;
        cube_1 = new CubeOfRubik(sizeOfCube);
        String cube_2 =
                "R  R  R  R  R     O  O  O  O  O     W  W  W  W  W     G  G  G  G  G     Y  Y  Y  Y  Y     B  B  B  B  B     \n" +
                "R  R  R  R  R     G  G  G  G  G     Y  Y  Y  Y  Y     O  O  O  O  O     W  W  W  W  W     B  B  B  B  B     \n" +
                "R  R  R  R  R     O  O  O  O  O     W  W  W  W  W     G  G  G  G  G     Y  Y  Y  Y  Y     B  B  B  B  B     \n" +
                "R  R  R  R  R     O  O  O  O  O     W  W  W  W  W     G  G  G  G  G     Y  Y  Y  Y  Y     B  B  B  B  B     \n" +
                "R  R  R  R  R     G  G  G  G  G     Y  Y  Y  Y  Y     O  O  O  O  O     W  W  W  W  W     B  B  B  B  B     \n";
        cube_1.rotateLayerRight(0);     // номер слоя
        cube_1.rotateLayerRight(2);
        cube_1.rotateLayerRight(3);
        cube_1.rotateLayerLeft(1);
        cube_1.rotateLayerLeft(4);
        assertEquals(cube_1.toString(), cube_2);

    }

    @Test
    public void rotateLayerLeft() {
        sizeOfCube = 15;        // чтобы было красиво и убедительно :)
        cube_1 = new CubeOfRubik(sizeOfCube);
        String cube_2 =
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n" +
        "R  R  R  R  R  R  R  R  R  R  R  R  R  R  R     W  W  W  W  W  W  W  W  W  W  W  W  W  W  W     G  G  G  G  G  G  G  G  G  G  G  G  G  G  G     Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y  Y     O  O  O  O  O  O  O  O  O  O  O  O  O  O  O     B  B  B  B  B  B  B  B  B  B  B  B  B  B  B     \n";
        cube_1.rotateLayerLeft(1);
        cube_1.rotateLayerLeft(3);
        cube_1.rotateLayerLeft(8);
        cube_1.rotateLayerLeft(13);
        assertEquals(cube_1.toString(), cube_2);
    }

    @Test
    public void numberRotateLayerRight() {
        sizeOfCube = 3;
        int number = 3; // 3 раза будем совершать вращение слоя
        int layer = 0;  // номер слоя
        cube_1 = new CubeOfRubik(sizeOfCube);
        String cube_2 =
                "R  R  R     G  G  G     Y  Y  Y     O  O  O     W  W  W     B  B  B     \n" +
                "R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B     \n" +
                "R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B     \n";
        cube_1.numberRotateLayerRight(number, layer);
        assertEquals(cube_1.toString(), cube_2);
    }

    @Test
    public void numberRotateLayerLeft() {
        sizeOfCube = 3;
        int number = 3; // 3 раза будем совершать вращение слоя
        int layer = 1;  // номер слоя
        cube_1 = new CubeOfRubik(sizeOfCube);
        String cube_2 =
                "R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B     \n" +
                "R  R  R     O  O  O     W  W  W     G  G  G     Y  Y  Y     B  B  B     \n" +
                "R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B     \n";
        cube_1.numberRotateLayerLeft(number, layer);
        assertEquals(cube_1.toString(), cube_2);
    }

    @Test
    public void toStringSpec() {        // покажем левую грань после преобразований пользователю
        int side = 1;
        sizeOfCube = 3;
        cube_1 = new CubeOfRubik(sizeOfCube);
        cube_1.numberRotateLayerRight(3, 0);
        String cube_2 =
                        "G  G  G     \n" +
                        "W  W  W     \n" +
                        "W  W  W     \n";
        assertEquals(cube_1.toStringSpec(side), cube_2);
    }

    @Test
    public void turnToUpSide() {
        sizeOfCube = 4;
        cube_1 = new CubeOfRubik(sizeOfCube);
        String cube_2_0 =
                "O  O  O  O     W  W  W  W     R  R  R  R     Y  Y  Y  Y     B  B  B  B     G  G  G  G     \n" +
                "O  O  O  O     W  W  W  W     R  R  R  R     Y  Y  Y  Y     B  B  B  B     G  G  G  G     \n" +
                "O  O  O  O     W  W  W  W     R  R  R  R     Y  Y  Y  Y     B  B  B  B     G  G  G  G     \n" +
                "O  O  O  O     W  W  W  W     R  R  R  R     Y  Y  Y  Y     B  B  B  B     G  G  G  G     \n";
        cube_1.turnToUpSide(4);
        assertEquals(cube_1.toString(), cube_2_0);

        sizeOfCube = 9;
        cube_1 = new CubeOfRubik(sizeOfCube);
        String cube_2 =
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n";
        cube_1.turnToUpSide(2);
        assertEquals(cube_1.toString(), cube_2);
    }

    @Test
    public void randomInst() {
        sizeOfCube = 3;
        cube_1 = new CubeOfRubik(sizeOfCube);
        CubeOfRubik cube_2 = new CubeOfRubik(sizeOfCube);
        cube_2.randomInst();
        Assert.assertNotEquals(cube_1.toString(), cube_2.toString());
    }
}