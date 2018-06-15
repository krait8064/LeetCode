package TopInterviewQuestions.ArrayAndStrings;

import java.util.ArrayDeque;

public class PalindromicNumbers {
    public static void main(String[] args) {

    }

    public static String paren(String origin) {
        if (origin == null || origin.length() == 1) {
            return origin;
        }
        String result = null;
        int start= 0;
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
}
