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
    if (this.columnSize != second.rowSize)
      return new Matrix(0,0,new int[0]);
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

  public int determinant(){
    return determinantTo(this.matrix);
  }

  private int determinantTo(int [][]matrix){
    int determinantValue = 0;
    if(matrix.length == 1)
      return(matrix[0][0]);
    for(int index=0;index < matrix.length;index++){
      int[][]determinantMatrix = new int[matrix.length-1][matrix.length-1];
      for(int initialRow=1;initialRow < matrix.length;initialRow++){
        for(int initialColumn=0 ; initialColumn < matrix.length ; initialColumn++){
          if(initialColumn<index)
            determinantMatrix[initialRow-1][initialColumn] = matrix[initialRow][initialColumn];
          if(initialColumn>index)
            determinantMatrix[initialRow-1][initialColumn-1] = matrix[initialRow][initialColumn];
        }
      }
      int signValue = (index % 2 == 0) ? 1 : -1;
      determinantValue += signValue*matrix[0][index]*(determinantTo(determinantMatrix));
    }
    return determinantValue;
  }


  public int getElement(int rowPosition,int columnPosition){
    return matrix[rowPosition][columnPosition];
  }
}
