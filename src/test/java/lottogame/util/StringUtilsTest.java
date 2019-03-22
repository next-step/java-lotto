package lottogame.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void isEmpty_for_empty_string() {
        assertTrue(StringUtils.isEmpty((String) null));
        assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void isEmpty_for_string() {
        assertFalse(StringUtils.isEmpty("aaa"));
    }

    @Test
    public void isEmpty_for_empty_list() {
        assertTrue(StringUtils.isEmpty((List<String>)null));
        assertTrue(StringUtils.isEmpty(Collections.emptyList()));
    }

    @Test
    public void isEmpty_for_list() {
        assertFalse(StringUtils.isEmpty(Arrays.asList("a")));
        assertFalse(StringUtils.isEmpty(Arrays.asList("a", "b", "c")));
    }

    @Test
    public void isEmpty_for_empty_array() {
        assertTrue(StringUtils.isEmpty((String[])null));
        assertTrue(StringUtils.isEmpty(new String[]{}));
    }

    @Test
    public void isEmpty_for_array() {
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

    @Test(expected = NullPointerException.class)
    public void parseIntegerSet_for_null() {
        assertEquals(Collections.emptySet(), StringUtils.parseIntegerSet(null));
    }

    @Test
    public void parseIntegerSet_for_empty_arrays() {
        assertEquals(Collections.emptySet(), StringUtils.parseIntegerSet(new String[]{}));
        assertEquals(Collections.emptySet(), StringUtils.parseIntegerSet(new String[]{""}));
        assertEquals(Collections.emptySet(), StringUtils.parseIntegerSet(new String[]{"", "", ""}));
    }

    @Test
    public void parseIntegerSet() {
        assertEquals(new HashSet(Arrays.asList(1)), StringUtils.parseIntegerSet(new String[]{"1"}));
        assertEquals(new HashSet(Arrays.asList(1, 5)), StringUtils.parseIntegerSet(new String[]{"1", "5"}));
        assertEquals(new HashSet(Arrays.asList(11, 33, 55)), StringUtils.parseIntegerSet(new String[]{"11", "33", "55"}));
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