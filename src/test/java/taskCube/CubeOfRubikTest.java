package taskCube;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class CubeOfRubikTest {
    /**
     * Строковое представление кубика в его начальном состоянии (3 на 3) (cubeOne)
     * R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B
     * R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B
     * R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B
     */

    @Test
    public void rotateLayerRight() {
        int sizeOfCube = 5;
        CubeOfRubik cubeOne = new CubeOfRubik(sizeOfCube);
        String cubeTwo =
                "R  R  R  R  R     O  O  O  O  O     W  W  W  W  W     G  G  G  G  G     Y  Y  Y  Y  Y     B  B  B  B  B     \n" +
                "R  R  R  R  R     G  G  G  G  G     Y  Y  Y  Y  Y     O  O  O  O  O     W  W  W  W  W     B  B  B  B  B     \n" +
                "R  R  R  R  R     O  O  O  O  O     W  W  W  W  W     G  G  G  G  G     Y  Y  Y  Y  Y     B  B  B  B  B     \n" +
                "R  R  R  R  R     O  O  O  O  O     W  W  W  W  W     G  G  G  G  G     Y  Y  Y  Y  Y     B  B  B  B  B     \n" +
                "R  R  R  R  R     G  G  G  G  G     Y  Y  Y  Y  Y     O  O  O  O  O     W  W  W  W  W     B  B  B  B  B     \n";
        cubeOne.rotateLayerRight(0);     // номер слоя
        cubeOne.rotateLayerRight(2);
        cubeOne.rotateLayerRight(3);
        cubeOne.rotateLayerLeft(1);
        cubeOne.rotateLayerLeft(4);
        assertEquals(cubeOne.toString(), cubeTwo);

    }

    @Test
    public void rotateLayerLeft() {
        int sizeOfCube = 15;        // чтобы было красиво и убедительно :)
        CubeOfRubik cubeOne = new CubeOfRubik(sizeOfCube);
        String cubeTwo =
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
        cubeOne.rotateLayerLeft(1);
        cubeOne.rotateLayerLeft(3);
        cubeOne.rotateLayerLeft(8);
        cubeOne.rotateLayerLeft(13);
        assertEquals(cubeOne.toString(), cubeTwo);
    }

    @Test
    public void numberRotateLayer() {
        int sizeOfCube = 3;
        int number = 3; // 3 раза будем совершать вращение слоя
        int layer = 0;  // номер слоя
        CubeOfRubik cubeOne = new CubeOfRubik(sizeOfCube);
        String cubeTwo =
                "R  R  R     G  G  G     Y  Y  Y     O  O  O     W  W  W     B  B  B     \n" +
                "R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B     \n" +
                "R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B     \n";
        cubeOne.numberRotateLayer(number, layer, CubeOfRubik.Direction.right);
        assertEquals(cubeOne.toString(), cubeTwo);

        int numberOne = 3; // 3 раза будем совершать вращение слоя
        int layerOne = 1;  // номер слоя
        cubeOne = new CubeOfRubik(sizeOfCube);
        String cubeThree =
                "R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B     \n" +
                "R  R  R     O  O  O     W  W  W     G  G  G     Y  Y  Y     B  B  B     \n" +
                "R  R  R     W  W  W     G  G  G     Y  Y  Y     O  O  O     B  B  B     \n";
        cubeOne.numberRotateLayer(numberOne, layerOne, CubeOfRubik.Direction.left);
        assertEquals(cubeOne.toString(), cubeThree);
    }

    @Test
    public void toStringSpec() {        // покажем левую грань после преобразований пользователю
        int side = 1;
        int sizeOfCube = 3;
        CubeOfRubik cubeOne = new CubeOfRubik(sizeOfCube);
        cubeOne.numberRotateLayer(3, 0, CubeOfRubik.Direction.right);
        String cubeTwo =
                        "G  G  G     \n" +
                        "W  W  W     \n" +
                        "W  W  W     \n";
        assertEquals(cubeOne.toStringSpec(side), cubeTwo);
    }

    @Test
    public void turnToUpSide() {
        int sizeOfCube = 4;
        CubeOfRubik cubeOne = new CubeOfRubik(sizeOfCube);
        String cubeTwo =
                "O  O  O  O     W  W  W  W     R  R  R  R     Y  Y  Y  Y     B  B  B  B     G  G  G  G     \n" +
                "O  O  O  O     W  W  W  W     R  R  R  R     Y  Y  Y  Y     B  B  B  B     G  G  G  G     \n" +
                "O  O  O  O     W  W  W  W     R  R  R  R     Y  Y  Y  Y     B  B  B  B     G  G  G  G     \n" +
                "O  O  O  O     W  W  W  W     R  R  R  R     Y  Y  Y  Y     B  B  B  B     G  G  G  G     \n";
        cubeOne.turnToUpSide(CubeOfRubik.Sides.B);
        assertEquals(cubeOne.toString(), cubeTwo);

        sizeOfCube = 9;
        cubeOne = new CubeOfRubik(sizeOfCube);
        String cubeThree =
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n" +
                "G  G  G  G  G  G  G  G  G     W  W  W  W  W  W  W  W  W     B  B  B  B  B  B  B  B  B     Y  Y  Y  Y  Y  Y  Y  Y  Y     R  R  R  R  R  R  R  R  R     O  O  O  O  O  O  O  O  O     \n";
        cubeOne.turnToUpSide(CubeOfRubik.Sides.F);
        assertEquals(cubeOne.toString(), cubeThree);
    }

    @Test
    public void randomInst() {
        int sizeOfCube = 3;
        CubeOfRubik cubeOne = new CubeOfRubik(sizeOfCube);
        CubeOfRubik cubeTwo = new CubeOfRubik(sizeOfCube);
        cubeTwo.randomInst();
        Assert.assertNotEquals(cubeOne.toString(), cubeTwo.toString());
    }
}