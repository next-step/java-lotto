package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class CalculatorStringRequestConverterTest {

    @DisplayName("올바른 형식의 문자열이라면, CalculatorRequest 객체로 변환되어야 한다.")
    @Test
    void convert() {
        String input = "1 + 2 - 3 * 4 / 5";
        CalculatorRequest expected = new CalculatorRequest(
                List.of(1, 2, 3, 4, 5),
                List.of(ArithmeticOperator.PLUS, ArithmeticOperator.MINUS, ArithmeticOperator.MULTIPLY, ArithmeticOperator.DIVIDE)
        );
        assertThat(CalculatorStringRequestConverter.convert(input)).isEqualTo(expected);
    }

    @DisplayName("숫자가 들어올 위치에 숫자가 아닌 다른 문자열이라면, 예외가 발생해야 한다.")
    @Test
    void convert_givenNotNumber() {
        String input = "a + 2";
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> CalculatorStringRequestConverter.convert(input));
    }

    @DisplayName("사칙연산 기호가 들어올 위치에 사칙연산 기호가 아닌 다른 문자열이라면, 예외가 발생해야 한다.")
    @Test
    void convert_givenNotOperator() {
        String input = "1 a 2";
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> CalculatorStringRequestConverter.convert(input));
    }

    @DisplayName("입력 받은 문자열의 마지막이 사칙 연산 기호라면, 예외가 발생해야 한다.")
    @Test
    void convert_givenOperatorLast() {
        String input = "1 +";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> CalculatorStringRequestConverter.convert(input));
    }

}
