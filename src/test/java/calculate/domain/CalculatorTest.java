package calculate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("3 더하기 2는 5다")
    void add() {
        assertThat(Calculator.add(3, 2)).isEqualTo(5);
    }

    @Test
    @DisplayName("5 빼기 2는 3이다")
    void subtract() {
        assertThat(Calculator.subtract(5, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("5 곱하기 3은 15다")
    void multiply() {
        assertThat(Calculator.multiply(5, 3)).isEqualTo(15);
    }

    @Test
    @DisplayName("나눗셈은 결과값을 정수로 나눈다 - 5 나누기 3은 1이다")
    void divide() {
        assertThat(Calculator.divide(5, 3)).isEqualTo(1);
    }
}