package lotto;

import lotto.domain.Calculator;
import lotto.domain.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("두 숫자를 더한다.")
    void 덧셈() {
        Calculator calculator = new Calculator(new Expression(new String[] { "2", "+", "3" }));
        assertThat(calculator.calculate()).isEqualTo(5);
    }

    @Test
    @DisplayName("두 숫자를 뺀다.")
    void 뺄셈() {
        Calculator calculator = new Calculator(new Expression(new String[] { "3", "-", "2" }));
        assertThat(calculator.calculate()).isEqualTo(1);
    }

    @Test
    @DisplayName("두 숫자를 곱한다.")
    void 곱셈() {
        Calculator calculator = new Calculator(new Expression(new String[] { "3", "*", "2" }));
        assertThat(calculator.calculate()).isEqualTo(6);
    }

    @Test
    @DisplayName("두 숫자를 나눈다.")
    void 나눗셈() {
        Calculator calculator = new Calculator(new Expression(new String[] { "4", "/", "2" }));
        assertThat(calculator.calculate()).isEqualTo(2);
    }

    @Test
    @DisplayName("두 숫자를 나눈 결과가 정수가 아닌 경우 소수점을 버린다.")
    void 나눗셈_반올림() {
        Calculator calculator = new Calculator(new Expression(new String[] { "3", "/", "2" }));
        assertThat(calculator.calculate()).isEqualTo(1);
    }
}
