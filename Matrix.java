import java.util.Arrays;
class Matrix{
  private int row;
  private int column;
  private int[][] matrix;

  private Matrix(int insertedRow,int insertedColumn){
    row = insertedRow;
    column = insertedColumn;
    matrix= new int[row][column];
  }

  public static Matrix intializeMatrix(int row,int column){
    return new Matrix(row,column);
  }

  public void giveMatrix (int [] userData){
    int index;
    int initialRow = 0;
    int initialColumn = 0;
    for (index = 0 ; index < userData.length ; index++ ){
      matrix[initialRow][initialColumn]=userData[index];
      initialColumn++;
      if (initialColumn == column) {
        initialRow++;
        initialColumn = 0;
      }
    }
  }
  
  public int[][] resultMatrix (){
    return matrix;
  }
}
