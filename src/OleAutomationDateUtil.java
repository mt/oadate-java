import java.util.TimeZone;
import java.util.Date;
import java.util.Calendar;

public class OleAutomationDateUtil {
    
    private long ONE_DAY = 24L * 60 * 60 * 1000;

    public Date fromOADate(double d, TimeZone tz) {

        long wholeDays = (long) d;
        double fracDays = Math.abs(d - wholeDays);

        long offset = (ONE_DAY * wholeDays) + (long) (fracDays * ONE_DAY);
        
        Date base = baseFor(tz);
        return new Date( base.getTime() + offset );
    }

    private Date baseFor(TimeZone tz) {

        Calendar c = Calendar.getInstance(tz);
        c.clear();
        c.set(1899,11,30,0,0,0);
        return c.getTime();
    }
}
