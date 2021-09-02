import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {
    private static final String BASIC_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\\n(.*)";

    @Test
    void basicCreate() {
        String text = "1,2,3";
        final Number actual = Number.createNumber(text);
        final Number expected = new Number(BASIC_DELIMITER, text.split(BASIC_DELIMITER));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void customCreate() {
        String text = "//;\n1;2;3";
        final Number actual = Number.createNumber(text);

        final Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        matcher.find();
        final String customDelimiter = matcher.group(1);
        final Number expected =  new Number(customDelimiter, matcher.group(2).split(customDelimiter));

        assertThat(actual).isEqualTo(expected);
    }
}