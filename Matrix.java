class Matrix{
  private int rowSize;
  private int columnSize;
  private int[][] matrix;

  public Matrix(int rowSize,int columnSize,int [] data){
    this.rowSize = rowSize;
    this.columnSize = columnSize;
    this.matrix = this.initialize(data);
  }

  private int [][] initialize (int [] matrixData){
    int index;
    int initialRow = 0;
    int initialColumn = 0;
    matrix = new int [rowSize][columnSize];
    for (index = 0 ; index < matrixData.length ; index++ ){
      matrix[initialRow][initialColumn]=matrixData[index];
      initialColumn++;
      if (initialColumn == columnSize) {
        initialRow++;
        initialColumn = 0;
      }
    }
    return matrix;
  }

  public Matrix add(Matrix second){
    int [][]addent = second.matrix;
    int [] result = new int[rowSize * columnSize];
    int index;
    int initialRow = 0;
    int initialColumn = 0;
    for (index = 0 ; index < result.length ; index++ ){
      result[index] = matrix[initialRow][initialColumn] + addent[initialRow][initialColumn];
      initialColumn++;
      if (initialColumn == columnSize) {
        initialRow++;
        initialColumn = 0;
      }
    }
    return new Matrix(rowSize,columnSize,result);
  }

  public Matrix multiply(Matrix second){
    int sum=0,index,initialRow,initialColumn,initialIndex=0;
    int [] multiplyResult = new int[this.rowSize*second.columnSize];
    for (index = 0 ; index < this.rowSize ; index++ ){
          for ( initialRow = 0 ; initialRow < second.columnSize ; initialRow++ ){
             for ( initialColumn = 0 ; initialColumn < this.rowSize ; initialColumn++ ){
                sum = sum + this.matrix[index][initialColumn]*second.matrix[initialColumn][initialRow];
             }
             multiplyResult[initialIndex] = sum;
             initialIndex++;
             sum = 0;
          }
    }
    return new Matrix(this.rowSize,second.columnSize,multiplyResult);
  }

  public int getElement(int rowPosition,int columnPosition){
    return matrix[rowPosition][columnPosition];
  }
}
