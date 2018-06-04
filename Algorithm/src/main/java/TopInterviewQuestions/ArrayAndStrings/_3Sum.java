package TopInterviewQuestions.ArrayAndStrings;

import java.util.ArrayList;
import java.util.List;

public class _3Sum {
    public static void main(String[] args) {
        int[] ar = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = get(ar);
        if (result != null && result.size() > 0) {
            int index = 0;
            for (List<Integer> item : result) {
                System.out.println("result:" + (index++) + "->" + item.toString());
            }
        }
    }

    public static List<List<Integer>> get(int[] arr) {
        if (arr == null || arr.length < 3)
            throw new IllegalArgumentException("arr not legal");
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }

}
