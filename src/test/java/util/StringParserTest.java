package util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {
    @Test
    public void str_to_int_array() {
        assertThat(StringParser.strToIntegerList("1, 2, 3")).contains(1,2,3);
    }

    @Test(expected = NumberFormatException.class)
    public void cannot_convert_to_int() {
        StringParser.strToIntegerList("1, 2, a");
    }
}
