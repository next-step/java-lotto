package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    void 입력값_빈값_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator("");
                });
    }

    @Test
    void 입력값_null값_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator(null);
                });
    }

    @Test
    void 입력값_숫자아닐때_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator("a");
                });
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2, 3", "1 + 2 * 3, 9", "1 + 2 * 3 / 4, 2"})
    void 사칙연산_모두_포함(String input, int expected) {
        Calculator calculator = new Calculator(input);
        assertThat(calculator.calculate(calculator.getNumbers(), calculator.getOperators())).isEqualTo(expected);
    }
}