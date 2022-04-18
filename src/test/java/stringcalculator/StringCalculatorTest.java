package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @ParameterizedTest(name = "null, 빈 문자열을 계산하면 예외를 던진다.")
    @NullAndEmptySource
    void process_GivenNullOrEmptyString_ThrowException(String expression) {
        assertThatThrownBy(() -> StringCalculator.calculate(expression))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙 연산자가 아닌 연산자가 있으면 예외를 던진다.")
    @Test
    void process_GivenInvalidOperator_ThrowException() {
        assertThatThrownBy(() -> StringCalculator.calculate("1 & 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 피연산자가 있으면 예외를 던진다.")
    @Test
    void process_GivenInvalidOperand_ThrowException() {
        assertThatThrownBy(() -> StringCalculator.calculate("1 + &"))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest(name = "정상 흐름")
    @CsvSource(value = {"2 + 3 * 4 / 2 : 10", "1 + 2 * 3 / 3 : 3"}, delimiter = ':')
    void process(String expression, int result) {
        assertThat(StringCalculator.calculate(expression))
                .isEqualTo(result);
    }
}
