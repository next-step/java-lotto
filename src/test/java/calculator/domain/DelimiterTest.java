package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.domain.Delimiter.DEFAULT_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {

    private Delimiter delimiter;
    private Matcher trueM;
    private Matcher falseM;
    private static String PATTERN = "//(.)\n(.*)";

    @BeforeEach
    void setUp() {
        //given
        delimiter = new Delimiter();
        trueM = Pattern.compile(PATTERN).matcher("//;\n1;2;3");
    }

    @Test
    void createTest() {
        //then
        assertThat(delimiter).isEqualTo(new Delimiter(DEFAULT_DELIMITER));
    }

    @Test
    void splitTest() {
        //given
        String str = "1:3,4";
        String[] predict = {"1", "3", "4"};
        Delimiter delimiter = new Delimiter(":|,");

        //when
        String[] result = delimiter.splitWithDelimiter(str);

        //then
        assertThat(result).isEqualTo(predict);
    }
}
