package TopInterviewQuestions.ArrayAndStrings;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

public class MaxLengthOfSubStringNoRepeating {

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
            for (int j = i; j < len; j++) {
                ch = str.charAt(j);
                if (!container.contains(ch)) {
                    container.add(ch);
                }else {
                    max = Math.max(container.size(), max);
                    container.clear();
                    break;
                }
                if (j == len - 1) {
                    max = Math.max(container.size(), max);
                    container.clear();
                    break;
                }
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

    @Test
    public void testCase(){
        Assert.assertEquals(5,maxSubstringLength1("helloworld"));
        Assert.assertEquals(1,maxSubstringLength1("bbbbb"));
        Assert.assertEquals(3,maxSubstringLength1("pwwkew"));
    }

}
