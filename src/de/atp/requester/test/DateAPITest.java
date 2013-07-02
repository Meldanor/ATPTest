package de.atp.requester.test;

import de.atp.date.ATPDate;
import de.atp.date.ATPDatetime;
import de.atp.date.ATPTime;
import junit.framework.TestCase;

public class DateAPITest extends TestCase {

    public void testNormalCreation() {

        ATPTime time = new ATPTime(10, 20, 30);
        assertTrue("Wrong hour, should be 10, but was " + time.getHour(), time.getHour() == 10);
        assertTrue("Wrong minute, should be 20, but was " + time.getMinute(), time.getMinute() == 20);
        assertTrue("Wrong second, should be 30, but was " + time.getSecond(), time.getSecond() == 30);
        System.out.println(time);

        ATPDate date = new ATPDate(13, 3, 1997);
        assertTrue("Wrong day, should be 13, but was " + date.getDay(), date.getDay() == 13);
        assertTrue("Wrong month, should be 3, but was " + date.getMonth(), date.getMonth() == 3);
        assertTrue("Wrong year, should be 1997, but was " + date.getYear(), date.getYear() == 1997);
        System.out.println(date);

        ATPDatetime dateTime = new ATPDatetime(13, 3, 1997, 10, 20, 30);
        assertTrue("Wrong hour, should be 10, but was " + dateTime.getHour(), dateTime.getHour() == 10);
        assertTrue("Wrong minute, should be 20, but was " + dateTime.getMinute(), dateTime.getMinute() == 20);
        assertTrue("Wrong second, should be 30, but was " + dateTime.getSecond(), dateTime.getSecond() == 30);

        assertTrue("Wrong day, should be 13, but was " + dateTime.getDay(), dateTime.getDay() == 13);
        assertTrue("Wrong month, should be 3, but was " + dateTime.getMonth(), dateTime.getMonth() == 3);
        assertTrue("Wrong year, should be 1997, but was " + dateTime.getYear(), dateTime.getYear() == 1997);
        System.out.println(dateTime);

        assertTrue("Times are different!", new ATPTime().equals(new ATPTime(System.currentTimeMillis())));
        assertTrue("Dates are different!", new ATPDate().equals(new ATPDate(System.currentTimeMillis())));
        assertTrue("Datetimes are different!", new ATPDatetime().equals(new ATPDatetime(System.currentTimeMillis())));
    }

    public void testOverflowCreation() {

        ATPTime time = new ATPTime(1, 61, 0);
        assertTrue("Wrong hour, should be 2 instead of " + time.getHour() + "(No overflow)", time.getHour() == 2);

        time = new ATPTime(0, 3, 60);
        assertTrue("Wrong minute, should be 4 instead of " + time.getMinute() + "(No overflow)", time.getMinute() == 4);

        time = new ATPTime(1, 59, 61);
        assertTrue("Wrong hour, should be 2 instead of " + time.getHour() + "(No overflow)", time.getHour() == 2);

        ATPDate date = new ATPDate(32, 7, 2013);
        assertTrue("Wrong day, should be 1 instead of " + date.getDay() + "(No overflow)", date.getDay() == 1);
        assertTrue("Wrong Month, should be 8 instead of " + date.getMonth() + "(No overflow)", date.getMonth() == 8);
        
        date = new ATPDate(32, 12, 2013);
        assertTrue("Wrong day, should be 1 instead of " + date.getDay() + "(No overflow)", date.getDay() == 1);
        assertTrue("Wrong Month, should be 1 instead of " + date.getMonth() + "(No overflow)", date.getMonth() == 1);
        assertTrue("Wrong Year, should be 2014 instead of " + date.getYear() + "(No overflow)", date.getYear() == 2014);
    }
}
