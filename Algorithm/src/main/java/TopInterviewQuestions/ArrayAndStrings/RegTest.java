package TopInterviewQuestions.ArrayAndStrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by krait8064 at 2019/06/21
 */
public class RegTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("([\\d]+)([a-zA-Z]+)");
        Matcher matcher = pattern.matcher("1c");
        if (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("the count " + i + " " + matcher.group(i));
            }
        }
        System.out.println("1c".matches("([\\d]+)([a-zA-Z]+)"));
    }
}
