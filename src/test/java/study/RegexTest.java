package study;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexTest {
    @Test
    void regexPattern() {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher("//;\n1;2;3");
        matcher.find();

        assertThat(matcher.group(1)).isEqualTo(";");
        assertThat(matcher.group(2)).isEqualTo("1;2;3");
    }
}
