package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("두 숫자를 더한다.")
    void 덧셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.add(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("두 숫자를 뺀다.")
    void 뺄셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.subtract(3, 2)).isEqualTo(1);
    }

    @Test
    @DisplayName("두 숫자를 곱한다.")
    void 곱셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.multiply(3, 2)).isEqualTo(6);
    }

    @Test
    @DisplayName("두 숫자를 나눈다.")
    void 나눗셈() {
        Calculator calculator = new Calculator();
        assertThat(calculator.divide(4, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("두 숫자를 나눈 결과가 정수가 아닌 경우 소수점을 버린다.")
    void 나눗셈_반올림() {
        Calculator calculator = new Calculator();
        assertThat(calculator.divide(3, 2)).isEqualTo(1);
    }
}
