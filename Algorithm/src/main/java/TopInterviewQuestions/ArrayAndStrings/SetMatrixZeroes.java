package TopInterviewQuestions.ArrayAndStrings;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] arr = {{1, 0, 2}, {2, 1, 3}, {1, 4, 0}};
        setZeroes(arr);
        System.out.println(convert2Arr(arr));
    }

    public static void setZeroes(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0)
            return;
        int row = arr.length;
        int col = arr[0].length;
        boolean rowZ = false;
        boolean colZ = false;
        for (int i = 0; i < row; i++) {
            if (arr[i][0] == 0) {
                colZ = true;
                break;
            }
        }
        for (int j = 0; j < col; j++) {
            if (arr[0][j] == 0) {
                rowZ = true;
                break;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i] == 0)
                set(arr, false, i);
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j][0] == 0)
                set(arr, true, j);
        }
        if (rowZ)
            set(arr, true, 0);
        if (colZ)
            set(arr, false, 0);

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

    private static String convert2Arr(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(Arrays.toString(arr[i]) + "\n");
        }
        return sb.toString();
    }

}
