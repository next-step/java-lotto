package calculator;

import calculator.exception.EmptyValueException;
import calculator.exception.InvalidValueException;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.DefaultCall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("사칙연산자, 공백, 숫자 외의 문자가 들어올 경우 예외")
    void wrongInput() {
        assertThatThrownBy(() -> Calculator.calculate("1 + 4 * 4 / 2 #"))
                .isInstanceOf(InvalidValueException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("공백 또는 null 값을 입력하면 예외가 발생한다.")
    void nullOrEmptyTest(String expected) {
        assertThatThrownBy(() -> Calculator.calculate(expected))
                .isInstanceOf(EmptyValueException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "100 + 100 * 2 / 2 = 200",
            "10 * 5 / 2 + 10 - 2 = 33",
            "10 + 10 / 2 + 1 * 4 = 44"
    }, delimiter = '=')
    @DisplayName("사칙연산자를 조합하여 계산한다")
    void calculateAll(String value, double expected) {
        double calculate = Calculator.calculate(value);
        assertThat(calculate).isEqualTo(expected);
    }
}
