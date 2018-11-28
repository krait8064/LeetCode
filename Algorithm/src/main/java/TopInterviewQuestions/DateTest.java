package TopInterviewQuestions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            c.setTime(sdf.parse("20160229"));
            c.add(Calendar.MONTH, 12);
            System.out.println(c.getTime().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
