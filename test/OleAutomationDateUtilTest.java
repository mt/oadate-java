import org.apache.commons.lang.time.DateUtils;

import java.util.Date;
import java.util.TimeZone;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class OleAutomationDateUtilTest {
    
    final OleAutomationDateUtil oadu = new OleAutomationDateUtil();
    final TimeZone GMT = TimeZone.getTimeZone("GMT");
    final TimeZone NEW_YORK = TimeZone.getTimeZone("America/New_York");
    
    @org.junit.Test
    public void wholeDays() {

        assertThat("Day 0"
                  , oadu.fromOADate(0, GMT)
                  , equalTo(d("Dec 30, 1899 00:00:00 am GMT")));
        
        assertThat("Day 1"
                  , oadu.fromOADate(1, GMT)
                  , equalTo(d("Dec 31, 1899 00:00:00 am GMT")));
        
        assertThat("Day 2"
                  , oadu.fromOADate(2, GMT)
                  , equalTo(d("Jan 1, 1900 00:00:00 am GMT")));

        assertThat("Day -1"
                  , oadu.fromOADate(-1, GMT)
                  , equalTo(d("Dec 29, 1899 00:00:00 am GMT")));
    }
    
    @org.junit.Test
    public void fractionalDays() {

        assertThat("Day 2.25"
                  , oadu.fromOADate(2.25, GMT)
                  , equalTo(d("Jan 1, 1900 06:00:00 am GMT")));
        
        assertThat("Day -1.25"
                  , oadu.fromOADate(-1.25, GMT)
                  , equalTo(d("Dec 29, 1899 06:00:00 am GMT")));
    }
    
    private Date d(String d) {
        try {
            return DateUtils.parseDate(d, new String[]{"MMM d, yyyy hh:mm:ss a z","MMM d, yyyy"});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

