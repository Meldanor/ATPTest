package de.atp.requester.test;

import junit.framework.TestCase;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import de.atp.data.Row;
import de.atp.data.RowStatus;

public class RowTest extends TestCase {

    public void testCreation() {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        Row row = new Row("abcde", today, now);

        assertTrue(row.getStatus().equals(RowStatus.DIRTY));
        assertTrue(row.getDate().equals(today));
        assertTrue(row.getCode().equals("abcde"));
    }

}
