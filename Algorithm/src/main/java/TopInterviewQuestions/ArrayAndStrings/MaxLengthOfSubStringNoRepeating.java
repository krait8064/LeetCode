package TopInterviewQuestions.ArrayAndStrings;

import java.util.*;

public class MaxLengthOfSubStringNoRepeating {
    public static void main(String[] args) {
        String test = "helloworld";

    }

    public static int maxSubstringLength1(String str) {
        if (str == null)
            throw new IllegalArgumentException("method:maxSubstringLength(String str) argument str null");
        int len = str.length();
        if (len == 1)
            return 1;
        HashSet<Character> container = new HashSet<>();
        Character ch;
        int max = -1;
        for (int i = 0; i < len; i++) {
            ch = str.charAt(i);
            if (container.contains(ch) || i == len - 1) {
                max = container.size();
                container.clear();
            } else {
                container.add(ch);
            }
        }
        return max;
    }

    public static int maxSubstringLength(String str) {
        if (str == null)
            throw new IllegalArgumentException("method:maxSubstringLength(String str) argument str null");
        int len = str.length();
        if (len == 1)
            return 1;
        Map<Character, TreeSet<Integer>> container = new HashMap<>();
        TreeSet<Integer> set;
        Character ch;
        for (int i = 0; i < len; i++) {
            ch = str.charAt(i);
            if (container.containsKey(ch)) {
                set = container.get(ch);
                set.add(i);
            } else {
                set = new TreeSet<>();
                set.add(i);
                container.put(ch, set);
            }
        }
        int max = -1;
        for (Map.Entry<Character, TreeSet<Integer>> entry : container.entrySet()) {
            set = entry.getValue();
            if (set.size() == 1) {
                max = Math.max(len - set.first(), max);
            } else {
                max = set.pollFirst();
                int prev = max;
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext()) {
                    Integer next = iterator.next();
                    max = Math.max(max, next - prev);
                    prev = next;
                }
            }
        }
        return max;
    }
}
