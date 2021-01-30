package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @DisplayName("null을 입력할 경우 0을 반환")
    @Test
    void nullReturnsZero() {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.calculate(null);

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("빈 문자열을 입력할 경우 0을 반환")
    @Test
    void emptyStringReturnsZero() {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.calculate("");

        // then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @Test
    void returnIntegerToInteger() {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.calculate("1");

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("컴마(,) 구분자로 입력할 경우 숫자들의 합을 반환")
    @Test
    void parseCommaReturnsSum() {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.calculate("1,2,3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("콜론(:) 구분자로 입력할 경우 숫자들의 합을 반환")
    @Test
    void parseColonReturnsSum() {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.calculate("1:2:3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("컴마(,), 콜론(:) 구분자로 입력할 경우 숫자들의 합을 반환")
    @Test
    void parseCommaAndColonReturnsSum() {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.calculate("1,2:3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정")
    @Test
    void customDelimiter() {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int result = calculator.calculate("//;\n1;2;3");

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외 발생")
    @Test
    void minusThrowsRuntimeException() {
        // given
        StringCalculator calculator = new StringCalculator();

        // when & then
        assertThrows(RuntimeException.class,
                () -> calculator.calculate("-1,2,3"));
    }
}