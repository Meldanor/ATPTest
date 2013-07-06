package de.atp.requester.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import junit.framework.TestCase;
import android.os.Environment;
import de.atp.controller.DataController;

public class ControllerTest extends TestCase {

    private final static String TEST_NAME = "testa";

    @Override
    protected void tearDown() throws Exception {
        File dir = Environment.getExternalStorageDirectory();
        File testFile = new File(dir, TEST_NAME + ".csv");
        testFile.delete();
        assertFalse(testFile.exists());

    }

    public void testControllerInstance() {
        DataController controller = DataController.instance("testa");
        assertFalse(controller == null);
        controller.createFirstAlarms(13, 00);
        assertTrue(checkCSVSyntax());
    }

    private final static String CSV_HEAD = "Code;Datum;Alarmzeit;Antwortzeit;Abbruch;Kontakte;Stunden;Minuten;";

    private boolean checkCSVSyntax() {
        File testFile = new File(Environment.getExternalStorageDirectory(), TEST_NAME + ".csv");
        try {

            BufferedReader bReader = new BufferedReader(new FileReader(testFile));
            String line = bReader.readLine();
            assertTrue("Head invalid, was " + line, line.equals(CSV_HEAD));

            line = bReader.readLine();
            String[] split = line.split(";");
            assertTrue("Wrong code, was " + split[0], split[0].equals(TEST_NAME));
            bReader.close();
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }

}
