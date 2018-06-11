package TopInterviewQuestions.ArrayAndStrings;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 2}};
        System.out.println(Arrays.toString(arr[0]));
    }

    public static void setZeroes(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0)
            return;
        int row = arr.length;
        int col = arr[0].length;
        int[] extras = new int[row + col];
        for (int i = 0; i < row + col; i++) {
            if ((i < row && arr[i][0] == 0) || (i >= row && arr[0][i - row] == 0))
                extras[i] = 0;
            else
                extras[i] = -1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < arr[0].length; i++) {
            if (arr[0][i] == 0)
                set(arr, false, i);
        }

        for (int j = 1; j < arr.length; j++) {
            if (arr[j][0] == 0)
                set(arr, true, j);
        }
        for (int i = 0; i < extras.length; i++) {
            if (i < row && extras[i] == 0)
                set(arr, true, i);
            if (i >= row && extras[i] == 0)
                set(arr, false, i - row);
        }

    }

    private static void set(int[][] arr, boolean row, int index) {
        if (row) {
            for (int i = 0; i < arr[index].length; i++) {
                arr[index][i] = 0;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i][index] = 0;
            }
        }
    }

}
