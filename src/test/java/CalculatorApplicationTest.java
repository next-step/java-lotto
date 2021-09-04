import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorApplicationTest {
    @Test
    void splitTest() {
        String[] args = {"1,2:3"};
        final String inputString = args[0];
        String basicRegex = ",|:";

        final String[] split = inputString.split(basicRegex);
        assertThat(split.length).isEqualTo(3);
    }

    @Test
    void matchTest() {
        String[] args = {"//;\n"};
        final String inputString = args[0];
        final String customRegex = "//.\\n";
        assertThat(Pattern.matches(customRegex, inputString)).isTrue();
    }

    @Test
    void customRegexMatchTest() {
        String[] args = {"//;\n1;2;3"};
        final String inputString = args[0];
        final String customRegex = "//(.)\\n(.*)";
        assertThat(Pattern.matches(customRegex, inputString)).isTrue();
    }

    @Test
    void basicRegexSuccessTest() {
        final String[] args = {"1,2:3"};
        final String inputString = args[0];

        final String basicRegex = ",|:";

        final String[] stringOfNumber = inputString.split(basicRegex);
        assertThat(stringOfNumber.length).isEqualTo(3);
    }

    @Test
    void customRegexSuccessTest() {
        final String[] args = {"//;\n1;2;3"};
        final String inputString = args[0];

        final String customRegex = "//(.)\\n(.*)";
        final Matcher matcher = Pattern.compile(customRegex).matcher(inputString);
        String[] stringOfNumber = null;
        if (matcher.find()) {
            final String delimiter = matcher.group(1);
            final String strings = matcher.group(2);
            stringOfNumber = strings.split(delimiter);
        }
        assertThat(stringOfNumber.length).isEqualTo(3);
    }

    @Test
    void mainTest() {
        CalculatorApplication.main(new String[]{"//;\n1;2;3"});
    }
}