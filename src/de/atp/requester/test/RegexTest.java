package de.atp.requester.test;

import java.util.regex.Pattern;

import junit.framework.TestCase;

public class RegexTest extends TestCase {

    private static final Pattern p = Pattern.compile("\\p{Alpha}{5}");

    public void testPattern() {

        assertTrue(p.matcher("abcde").matches());

        assertFalse(p.matcher("abc1de").matches());

        assertFalse(p.matcher("").matches());

        assertFalse(p.matcher("1").matches());
        assertFalse(p.matcher("a").matches());
    }

}
