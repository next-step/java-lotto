package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    void 더하기() {
        Calculator calculator = new Calculator();
        Number result = calculator.add(new Number(6), new Number(3));
        assertThat(result.value()).isEqualTo(9);
    }

    @Test
    void 빼기() {
        Calculator calculator = new Calculator();
        Number result = calculator.subtract(new Number(6), new Number(3));
        assertThat(result.value()).isEqualTo(3);
    }

    @Test
    void 곱하기() {
        Calculator calculator = new Calculator();
        Number result = calculator.multiply(new Number(6), new Number(3));
        assertThat(result.value()).isEqualTo(18);
    }

    @Test
    void 나누기() {
        Calculator calculator = new Calculator();
        Number result = calculator.divide(new Number(6), new Number(3));
        assertThat(result.value()).isEqualTo(2);
    }

    @Test
    void 나누기오류_0으로_나누는경우() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> {
            calculator.divide(new Number(6), new Number(0));
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
