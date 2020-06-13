package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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
    @ValueSource(strings = {"1,2", "1:2"})
    public void whenPutTwoIntStringWithCommaOrColonSeparator_thenReturnSumOfThem(String expression) {
        int sum = StringAddCalculator.calculate(expression);
        assertThat(sum).isEqualTo(3);
    }
}
