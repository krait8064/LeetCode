package TopInterviewQuestions.ArrayAndStrings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class YearPartitionGenerator {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyyMM");
        int bound = 10;
        for (int i = 0; i < bound * 12; i++) {
            String ym = df.format(c.getTime()).concat("01");
            System.out.println(ym);
            c.add(Calendar.MONTH, 1);
        }

    }
}
