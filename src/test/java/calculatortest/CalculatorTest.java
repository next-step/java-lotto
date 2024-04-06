
package calculatortest;

import calculator.domain.Calculate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

public class CalculatorTest {
    //given
    Calculate calculate = new Calculate();

    @ParameterizedTest
    @DisplayName("calculate")
    @ValueSource(strings = {"1 + 2 * 3 / 4"})
    public void calculate(String expression) {
        // when, then
        Assertions.assertThat(calculate.calculate(expression)).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("Exceptions of calculator")
    @NullAndEmptySource
    @ValueSource(strings = {"4@3", "4 @ 3", "4 / 0"})
    public void wrongCalculator(String expression) {
        Assertions.assertThatThrownBy(() -> {
            calculate.calculate(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
