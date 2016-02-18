import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MatrixTest {
  @Test
  public void matrixInitialTest() {
    int []data = {2,3,4,3,4,5,6,5,7};
    Matrix userMatrix = new Matrix (3,3,data);
    assertEquals(2,userMatrix.getElement(0,0));
    assertEquals(3,userMatrix.getElement(0,1));
    assertEquals(7,userMatrix.getElement(2,2));
  }
  @Test
  public void matrixAddTest() {
    int []data1 = {2,3,4,3};
    int []data2 = {3,4,5,4};
    Matrix matrix1 = new Matrix (2,2,data1);
    Matrix matrix2 = new Matrix (2,2,data2);
    Matrix result = matrix1.add(matrix2);

    assertEquals(7,result.getElement(1,1));
    assertEquals(9,result.getElement(1,0));
  }
  @Test
  public void matrixMultiplicationTestForTwoEqualSizeMatrix() {
    int []data1 = {2,3,4,3};
    int []data2 = {3,4,5,4};
    Matrix matrix1 = new Matrix (2,2,data1);
    Matrix matrix2 = new Matrix (2,2,data2);
    Matrix result = matrix1.multiply(matrix2);

    assertEquals(21,result.getElement(0,0));
    assertEquals(20,result.getElement(0,1));
    assertEquals(27,result.getElement(1,0));
    assertEquals(28,result.getElement(1,1));
  }

}
