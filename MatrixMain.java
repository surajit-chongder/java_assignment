class MatrixMain{
  public static void main(String[] args) {
    Matrix userMatrix = Matrix.intializeMatrix(3,3);
    int []data = {2,3,4,3,4,5,6,5,7};
    userMatrix.giveMatrix(data);
  }
}
