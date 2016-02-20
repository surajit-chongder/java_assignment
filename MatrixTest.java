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
  @Test
  public void matrixDeterminantTest() {
    int []data = {2,3,4,3};
    Matrix matrix = new Matrix (2,2,data);
    int result = matrix.determinant();
    assertEquals(-6,result);
  }
  @Test
  public void matrixDeterminantTestOF3By3Matrix() {
    int []data = {2,4,3,5,6,4,5,6,2};
    Matrix matrix = new Matrix (3,3,data);
    int result = matrix.determinant();
    assertEquals(16,result);
  }
  @Test
  public void matrixDeterminantTestOF10By10Matrix() {
    int []data = {1,2,3,4,5,6,7,8,9,
                  1,2,3,4,5,6,7,8,9,
                  1,2,3,4,5,6,7,8,9,
                  1,2,3,4,5,6,7,8,9,
                  1,2,3,4,5,6,7,8,9,
                  1,2,3,4,5,6,7,8,9,
                  1,2,3,4,5,6,7,8,9,
                  1,2,3,4,5,6,7,8,9,
                  1,2,3,4,5,6,7,8,9,
                  1,2,3,4,5,6,7,8,9,
                  1,2,3,4,5,6,7,8,9,1};
    Matrix matrix = new Matrix (10,10,data);
    int result = matrix.determinant();
    assertEquals(0,result);
  }

}
