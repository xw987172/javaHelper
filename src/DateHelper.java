import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateHelper {
    public static String getDay(int n){

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cal.add(Calendar.DATE,n);
        return sdf.format(cal.getTime());
    }
}
