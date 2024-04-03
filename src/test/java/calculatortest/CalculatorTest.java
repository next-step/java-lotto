
package calculatortest;

import calculator.domain.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

public class CalculatorTest {
    //given
    Calculator calculator = new Calculator();

    @ParameterizedTest
    @DisplayName("calculator")
    @ValueSource(strings = {"4 + 3 * 2 / 1"})
    public void calculator(String string) {
        ByteArrayInputStream input = new ByteArrayInputStream(string.getBytes());
        System.setIn(input);
        Assertions.assertThat(calculator.calculate()).isEqualTo(14);
    }

    @ParameterizedTest
    @DisplayName("Exceptions of calculator")
    @NullAndEmptySource
    @ValueSource(strings = {"4@3", "4 @ 3", "4 / 0"})
    public void wrongCalculator(String string) {
        ByteArrayInputStream input = new ByteArrayInputStream(string.getBytes());
        System.setIn(input);
        Assertions.assertThatThrownBy(() -> {
            calculator.calculate();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
