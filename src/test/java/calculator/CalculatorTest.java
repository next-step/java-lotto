package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    void 덧셈_테스트() {
        Calculator cal = new Calculator(5);
        assertThat(cal.add(5)).isEqualTo(10);
    }

    @Test
    void 뺄셈_테스트() {
        Calculator cal = new Calculator(5);
        assertThat(cal.subtract(3)).isEqualTo(2);
    }

    @Test
    void 곱셈_테스트() {
        Calculator cal = new Calculator(5);
        assertThat(cal.multiply(2)).isEqualTo(10);
    }

    @Test
    void 나눗셈_테스트() {
        Calculator cal = new Calculator(5);
        assertThat(cal.divide(5)).isEqualTo(1);
    }

    @Test
    void 나눗셈_에러_체크() {
        assertThatThrownBy(() -> {
            Calculator cal = new Calculator(5);
            cal.divide(3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공식의_답_체크() {

        String formula = "2 + 3 * 4 / 2";

        assertThat(new Calculator(formula).calculateFormula()).isEqualTo(10);
    }
}