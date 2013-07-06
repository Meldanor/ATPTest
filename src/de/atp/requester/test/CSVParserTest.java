package de.atp.requester.test;

import junit.framework.TestCase;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import de.atp.data.Row;
import de.atp.parser.csv.CSVParser;

public class CSVParserTest extends TestCase {

    private final static String[] HEAD = {"Code", "Datum", "Alarmzeit", "Antwortzeit", "Abbruch", "Kontakte", "Stunden", "Minuten"};

    public void testBla() {
        CSVParser parser = new CSVParser("abcde", HEAD);
        Row row = new Row("abcde", LocalDate.now(), LocalTime.now());
        String bla = parser.writeRow(row);
        assertFalse(bla == null);
        assertTrue(bla.contains(";"));
    }

}
