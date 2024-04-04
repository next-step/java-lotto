
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

    @Test
    @DisplayName("calculate")
    public void calculate() {
        // given

        // when, then
        Assertions.assertThat(calculate.calculate()).isEqualTo(14);
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
