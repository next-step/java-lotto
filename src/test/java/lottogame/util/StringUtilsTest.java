package lottogame.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void isEmpty() {
        assertTrue(StringUtils.isEmpty((String)null));
        assertTrue(StringUtils.isEmpty(""));
        assertFalse(StringUtils.isEmpty("aaa"));

        assertTrue(StringUtils.isEmpty((List<String>)null));
        assertTrue(StringUtils.isEmpty(Collections.emptyList()));
        assertFalse(StringUtils.isEmpty(Arrays.asList("a")));
        assertFalse(StringUtils.isEmpty(Arrays.asList("a", "b", "c")));

        assertTrue(StringUtils.isEmpty((String[])null));
        assertTrue(StringUtils.isEmpty(new String[]{}));
        assertFalse(StringUtils.isEmpty(new String[]{"a"}));
        assertFalse(StringUtils.isEmpty(new String[]{"a", "b", "c"}));
    }

    @Test
    public void repeat_for_empty_string() {
        String expected = "";

        assertEquals(expected, StringUtils.repeat(null, 1));
        assertEquals(expected, StringUtils.repeat("", 1));
    }

    @Test
    public void repeat() {
        assertEquals("", StringUtils.repeat("a", -1));
        assertEquals("", StringUtils.repeat("a", 0));
        assertEquals("aaaaa", StringUtils.repeat("a", 5));
        assertEquals("abc", StringUtils.repeat("abc", 1));
        assertEquals("abcdabcdabcd", StringUtils.repeat("abcd", 3));
    }

    @Test
    public void parseInt() {
        assertEquals(0, StringUtils.parseInt(null));
        assertEquals(0, StringUtils.parseInt(""));
        assertEquals(0, StringUtils.parseInt("a"));
        assertEquals(12345, StringUtils.parseInt("12345"));
        assertEquals(Integer.MAX_VALUE+1, StringUtils.parseInt(String.valueOf(Integer.MAX_VALUE+1)));
        assertEquals(Integer.MIN_VALUE-1, StringUtils.parseInt(String.valueOf(Integer.MIN_VALUE-1)));
    }

    @Test
    public void parseLong() {
        assertEquals(0L, StringUtils.parseLong(null));
        assertEquals(0L, StringUtils.parseLong(""));
        assertEquals(0L, StringUtils.parseLong("a"));
        assertEquals(0L, StringUtils.parseInt(String.valueOf(Long.MAX_VALUE+1)));
        assertEquals(0L, StringUtils.parseInt(String.valueOf(Long.MIN_VALUE-1)));
        assertEquals(12345L, StringUtils.parseInt("12345"));
    }

    @Test
    public void parseIntegerList_for_empty_arrays() {
        assertEquals(Collections.emptyList(), StringUtils.parseIntegerList(null));
        assertEquals(Collections.emptyList(), StringUtils.parseIntegerList(new String[]{}));
        assertEquals(Collections.emptyList(), StringUtils.parseIntegerList(new String[]{""}));
        assertEquals(Collections.emptyList(), StringUtils.parseIntegerList(new String[]{"", "", ""}));
    }

    @Test
    public void parseIntegerList() {
        assertEquals(Arrays.asList(1), StringUtils.parseIntegerList(new String[]{"1"}));
        assertEquals(Arrays.asList(1, 5), StringUtils.parseIntegerList(new String[]{"1", "5"}));
        assertEquals(Arrays.asList(11, 33, 55), StringUtils.parseIntegerList(new String[]{"11", "33", "55"}));
    }

    @Test
    public void removeWhiteSpace() {
        assertEquals("", StringUtils.removeWhitespace(null));
        assertEquals("", StringUtils.removeWhitespace(""));
        assertEquals("", StringUtils.removeWhitespace(" "));
        assertEquals("", StringUtils.removeWhitespace("      "));
        assertEquals("a", StringUtils.removeWhitespace("  a    "));
        assertEquals("abc", StringUtils.removeWhitespace("  a   b       c"));
    }
}