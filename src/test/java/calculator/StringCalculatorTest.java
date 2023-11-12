package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static calculator.StringCalculator.cal;

public class StringCalculatorTest {
    @DisplayName("null 테스트")
    @Test
    void nullTest() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cal(null)).withMessage("빈 문자가 입력되었습니다.");
    }

    @DisplayName("빈문자열 테스트")
    @Test
    void emptyTest() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cal("")).withMessage("빈 문자가 입력되었습니다.");
    }

    @DisplayName("첫번째 문자 숫자 아닌 것 테스트")
    @Test
    void notNumberTest() {
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> cal("*")).withMessage("For input string: \"*\"");
    }

    @DisplayName("숫자 자리에 숫자가 아닌 것 들어오는 테스트")
    @Test
    void notNumberTest2() {
        Assertions.assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> cal("1 + 3 + +")).withMessage("For input string: \"+\"");
    }

    @DisplayName("연산자 자리에 연산자 아닌 것 들어오는 테스트")
    @Test
    void notOperationTest() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cal("1 1 1")).withMessage("올바른 연산자가 입력되지 않았습니다.");
    }

    @DisplayName("올바른 결과값 테스트")
    @Test
    void calculatorTest() {
        assertThat(cal("1 + 2 + 3 * 4")).isEqualTo(24);
    }

    @DisplayName("올바른 결과값 테스트2")
    @Test
    void calculatorTest2() {
        assertThat(cal("1 + 3 / 2")).isEqualTo(2);
    }

    @DisplayName("올바른 결과값 테스트3")
    @Test
    void calculatorTest3() {
        assertThat(cal("1 + 1 - 3 * 2 / 2")).isEqualTo(-1);
    }
}
