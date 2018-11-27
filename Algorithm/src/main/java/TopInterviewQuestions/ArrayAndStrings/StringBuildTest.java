package TopInterviewQuestions.ArrayAndStrings;

public class StringBuildTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("helloworld");
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());

    }
}
