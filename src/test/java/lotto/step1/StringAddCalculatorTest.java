package lotto.step1;

import lotto.step1.model.Expression;
import lotto.step1.model.StringAddCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest(name = "illegalArgumentExceptionTest")
    @ValueSource(strings = {"//\n1:2:3", "1d,2,3", "//;\n1;2;a;3"})
    public void illegalArgumentExceptionTest(String input) {
        assertThatThrownBy(() -> StringAddCalculator.sum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "sumTest")
    @CsvSource(value = {"'//f\n1f2f3'@6", "'4,7:3'@14", "'//;\n5;2;13'@20"}, delimiter = '@')
    public void sumTest(String expression, int result) {
        assertThat(StringAddCalculator.sum(expression)).isEqualTo(result);
    }

}
