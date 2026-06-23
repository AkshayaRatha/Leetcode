class Solution {
     public static int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] transMatrix = new int[cols][rows];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transMatrix[j][i] = matrix[i][j];
            }
        }
        return transMatrix;
    }
    
}