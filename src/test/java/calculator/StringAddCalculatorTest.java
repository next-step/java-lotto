package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class StringAddCalculatorTest {
    @Test
    public void whenNullOrEmptyString_thenZero() {
        int nullResult = StringAddCalculator.calculate(null);
        assertThat(nullResult).isEqualTo(0);
        int emptyStringResult = StringAddCalculator.calculate("");
        assertThat(emptyStringResult).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    public void whenPutASingleInt_thenReturnItAsInt(Integer value) {
        int result = StringAddCalculator.calculate(value.toString());
        assertThat(result).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1:2", "1:1,1"})
    public void whenPutIntStringsWithCommaOrColonSeparator_thenReturnSumOfThem(String expression) {
        int sum = StringAddCalculator.calculate(expression);
        assertThat(sum).isEqualTo(3);
    }

    @Test
    public void whenPutIntStringWithCustomSeparator_thenReturnSumUsingTheSeparator() {
        int sum = StringAddCalculator.calculate("//;\n1;2;3");
        assertThat(sum).isEqualTo(6);
    }

    @Test
    public void patternMatcherTest() {
        String given = "//ak\nbcd";
        Matcher matcher = Pattern.compile("//.+\n").matcher(given);
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group()).isEqualTo("//ak\n");
        assertThatIllegalStateException().isThrownBy(() -> {
            Pattern.compile("////").matcher(given).group();
        });
    }

}
