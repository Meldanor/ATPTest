package de.atp.requester.test;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import junit.framework.TestCase;
import de.atp.data.DataTable;
import de.atp.data.Row;

public class DataTableTest extends TestCase {

    public void testCreation() {
        DataTable table = new DataTable();
        assertFalse(table.getRows() == null);
        assertTrue(table.getRows().isEmpty());

        List<Row> rows = new ArrayList<Row>();
        rows.add(new Row("abcde", LocalDate.now(), LocalTime.now()));
        table = new DataTable(rows);
        assertFalse(table.getRows() == null);
        assertFalse(table.getRows().isEmpty());
        assertTrue(table.getRows().size() == 1);
        // DataTable always returns a copy of list instead on an reference
        assertFalse(table.getRows() == rows);
    }

}
