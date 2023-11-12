package step1.domain;

import org.junit.jupiter.api.Test;
import step1.domain.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    void 더하기() {
        Calculator calculator = new Calculator();
        int result = calculator.add(6, 3);
        assertThat(result).isEqualTo(9);
    }

    @Test
    void 빼기() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(6, 3);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 곱하기() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(6, 3);
        assertThat(result).isEqualTo(18);
    }

    @Test
    void 나누기() {
        Calculator calculator = new Calculator();
        int result = calculator.divide(6, 3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 나누기오류_0으로_나누는경우() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> {
            calculator.divide(6, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}