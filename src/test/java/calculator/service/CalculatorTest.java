package calculator.service;

import calculator.service.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2,10", "1 + 1,2", "1 - 1,0", "0 - 1,-1", "1 * 1, 1", "1 / 1, 1", "0 + 0, 0"})
    void 순서대로_계산이_되어야한다(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10 / 3", "10 / 4"})
    void 나눗셈은_정수로_떨어지는_값으로_한정한다(String input, boolean expected) {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> {
                    Calculator.calculate(input);
                });
    }
}
