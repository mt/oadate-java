/*
 * Copyright Mathew Thomas, 2011
 * The use and distribution terms for this software are 
 * covered by the The zlib License: http://opensource.org/licenses/Zlib
 */


import java.util.TimeZone;
import java.util.Date;
import java.util.Calendar;

public class OleAutomationDateUtil {
    
    private long ONE_DAY = 24L * 60 * 60 * 1000;

    /*
     * The OLE automation date format is a floating point value, 
     * counting days since midnight 30 December 1899. 
     * Hours and minutes are represented as fractional days.
     * An OLE Automation date is implemented as a floating-point number 
     * whose integral component is the number of days before or 
     * after midnight, 30 December 1899, and whose fractional component 
     * represents the time on that day divided by 24. 
     *
     * For example, midnight, 31 December 1899 is represented by 1.0; 
     * 6 A.M., 1 January 1900 is represented by 2.25; 
     * midnight, 29 December 1899 is represented by -1.0; 
     * and 6 A.M., 29 December 1899 is represented by -1.25.
     *
     * The base OLE Automation Date is midnight, 30 December 1899. The 
     * minimum OLE Automation date is midnight, 1 January 0100. The maximum 
     * OLE Automation Date is the last moment of 31 December 9999.
     */
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
