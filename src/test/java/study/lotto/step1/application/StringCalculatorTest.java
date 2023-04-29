package study.lotto.step1.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    @Test
    @DisplayName("피연산자의 갯수가 연산자의 갯수보다 하나 많지 않을 경우, IllegalArgumentException 예외 발생")
    void invalid_expression_then_throw_IllegalArgumentException() {
        // given
        String invalidExpression = "2 + 3 *";

        // when, then
        assertThatThrownBy(() -> StringCalculator.calculate(invalidExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자의 갯수는 피연산자의 갯수보다 하나 많아야 합니다. 연산자 수: 2, 피연산자 수: 2");
    }

    @Test
    void calculate() {
        // given
        String expression = "2 + 3 * 4 / 2";

        // when, then
        assertThat(StringCalculator.calculate(expression)).isEqualTo("10");
    }
}