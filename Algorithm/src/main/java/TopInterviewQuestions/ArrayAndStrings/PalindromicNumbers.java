package TopInterviewQuestions.ArrayAndStrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;

public class PalindromicNumbers {

    public static String paren(String origin) {
        if (origin == null || origin.length() == 1) {
            return origin;
        }
        String result = null;
        int start = 0;
        for (int i = 0; i < origin.length() - 1; i++) {
            int a = 121212121;
            int r = 12345;
        }
        return result;
    }

    private static String reverse(String origin) {
        char[] src = origin.toCharArray();
        char[] target = new char[src.length];
        for (int i = 0; i < src.length; i++) {
            target[i] = src[src.length - 1 - i];
        }
        return String.valueOf(target);
    }

    public  String longestPalindromicSubstring(String origin) {
        if (origin == null || origin.length() == 1) {
            return origin;
        }
        for (int i = 0; i < origin.length(); i++) {
            palindrome(origin, i, i);
            palindrome(origin, i, i + 1);
        }
        return origin.substring(start, max);

    }

    private void palindrome(String origin, int j, int k) {
        while (j >= 0 && k < origin.length() && origin.charAt(j) == origin.charAt(k)) {
            j--;
            k++;
        }
        if (max < k - j + 1) {
            max = k - j + 1;
            start = k;
        }
    }

    private int start = 0,max = 0;

    @Test
    private void palindromeTest() {
        PalindromicNumbers p = new PalindromicNumbers();
        Assert.assertEquals(p.longestPalindromicSubstring("abbaa"),"abba");
        Assert.assertEquals(p.longestPalindromicSubstring("abcba"),"abcba");
        Assert.assertEquals(p.longestPalindromicSubstring("wwweabcbadku"),"abcba");
        Assert.assertEquals(p.longestPalindromicSubstring("abcba"),"abcba");
    }
}
