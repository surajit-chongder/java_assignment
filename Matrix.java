import java.util.Arrays;
class Matrix{
  private int row;
  private int column;
  private int[][] matrix;

  public Matrix(int insertedRow,int insertedColumn,int [] userData){
    row = insertedRow;
    column = insertedColumn;
    matrix= new int[row][column];
    matrix = this.createMatrix(userData);
  }

  private int [][] createMatrix (int [] matrixData){
    int index;
    int initialRow = 0;
    int initialColumn = 0;
    for (index = 0 ; index < matrixData.length ; index++ ){
      matrix[initialRow][initialColumn]=matrixData[index];
      initialColumn++;
      if (initialColumn == column) {
        initialRow++;
        initialColumn = 0;
      }
    }
    return matrix;
  }

  public Matrix add(Matrix second){
    int [][]addent = second.matrix;
    int [] result = new int[row * column];
    int index;
    int initialRow = 0;
    int initialColumn = 0;
    for (index = 0 ; index < row*column ; index++ ){
      result[index] = matrix[initialRow][initialColumn] + addent[initialRow][initialColumn];
      initialColumn++;
      if (initialColumn == column) {
        initialRow++;
        initialColumn = 0;
      }
    }
    return new Matrix(row,column,result);
  }


  public int getElement(int rowPosition,int columnPosition){
    return matrix[rowPosition][columnPosition];
  }
}
