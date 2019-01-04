package TopInterviewQuestions.ArrayAndStrings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Day2019PartitionGenerator {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        try {
            c.setTime(df.parse("20190101"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int bound = 365;
        for (int i = 0; i < bound; i++) {
            if (valid(c.get(Calendar.MONTH), c.get(Calendar.DATE))) {
                String ym = df.format(c.getTime()) + ",";
                System.out.print(ym);
            }
            c.add(Calendar.DATE, 1);
        }

    }

    private static boolean valid(int month, int day) {
        return !(month == 1 && day >= 4 && day <= 7);
    }
}
