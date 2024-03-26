
package calculatortest;

import calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    //given
    Calculator calculator = new Calculator();

    @ParameterizedTest
    @DisplayName("calculator")
    @ValueSource(strings = {"4 + 3 * 2 / 1"})
    public void calculator(String string) {
        Assertions.assertThat(calculator.calculate(string)).isEqualTo(14);
    }

    @ParameterizedTest
    @DisplayName("Exceptions of calculator")
    @NullAndEmptySource
    @ValueSource(strings = {"4@3", "4 @ 3", "4 / 0"})
    public void wrongCalculator(String string) {
        Assertions.assertThatThrownBy(() -> {
            calculator.calculate(string);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
