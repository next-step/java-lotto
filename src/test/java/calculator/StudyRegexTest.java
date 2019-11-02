package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by yusik on 2019/11/02.
 */
public class StudyRegexTest {

    @Test
    void splitRegex() {
        String[] tokens = "a,b:c.z".split("[,.:]");
        Arrays.stream(tokens).forEach(System.out::println);

        assertThat(tokens[0]).isEqualTo("a");
    }

    @Test
    void regexGroup() {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher("//A\nTEST");
        if (matcher.find()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));

            assertThat(matcher.group(1)).isEqualTo("A");
            assertThat(matcher.group(2)).isEqualTo("TEST");
        }
    }
}
