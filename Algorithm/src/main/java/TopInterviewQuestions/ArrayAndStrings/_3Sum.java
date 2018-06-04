package TopInterviewQuestions.ArrayAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
    public static void main(String[] args) {
        int[] ar = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = betterGet(ar);
        if (result != null && result.size() > 0) {
            int index = 0;
            for (List<Integer> item : result) {
                System.out.println("result:" + (index++) + "->" + item.toString());
            }
        }
    }

    /**
     * O(n^3)
     * just for loop
     */
    public static List<List<Integer>> get(int[] arr) {
        if (arr == null || arr.length < 3)
            throw new IllegalArgumentException("arr not legal");
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }
        return result;
    }

    /**
     * sort to lower time complexity -> O(n^2)
     */
    public static List<List<Integer>> betterGet(int[] arr) {
        Arrays.sort(arr);
        int index = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (index++ < arr.length - 2) {
            int lo = index + 1;
            int hi = arr.length - 1;
            while (lo < hi) {
                if (arr[lo] + arr[hi] == -arr[index]) {
                    result.add(Arrays.asList(arr[index], arr[lo], arr[hi]));
                    lo++;
                    hi--;
                    while (lo < hi && arr[lo] == arr[lo + 1]) lo++;
                    while (lo < hi && arr[hi] == arr[hi - 1]) hi--;
                } else if (arr[lo] + arr[hi] < -arr[index]) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return result;
    }

}
