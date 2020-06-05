package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(new CalculationText(null));
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(new CalculationText(""));
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1^1",
            "1,2^3",
            "1,2:3^6"},
            delimiter = '^')
    void splitAndSum_test(String calText, int expected) {
        int resultNumber = StringAddCalculator.splitAndSum(new CalculationText(calText));
        assertThat(resultNumber).isEqualTo(expected);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum(new CalculationText("//;\n1;2;3"));
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(new CalculationText("-1,2,3")))
                .isInstanceOf(RuntimeException.class);
    }
}