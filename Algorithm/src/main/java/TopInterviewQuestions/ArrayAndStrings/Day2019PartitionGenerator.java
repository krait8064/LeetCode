package TopInterviewQuestions.ArrayAndStrings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Day2019PartitionGenerator {
    public static final String FORMAT = "PARTITION p%d VALUES LESS THAN (%d) ENGINE=InnoDB,";

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        int bound = Integer.parseInt(args[0]);
        String startDate = args[1];
        String format = args[2];
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            c.setTime(df.parse(startDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bound; i++) {
            int ymd = Integer.parseInt(df.format(c.getTime()));
            System.out.println(String.format(FORMAT, ymd, ymd + 1));
            c.add(Calendar.DATE, 1);
        }

    }

}
