package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void 덧셈테스트() {
        Calculator cal = new Calculator();
        assertThat(cal.calculate("1 + 2")).isEqualTo(3);
    }

    @Test
    void 뺄셈테스트() {
        Calculator cal = new Calculator();
        assertThat(cal.calculate("3 - 1")).isEqualTo(2);
    }

    @Test
    void 나눗셈테스트() {
        Calculator cal = new Calculator();
        assertThat(cal.calculate("6 / 2")).isEqualTo(3);
    }

    @Test
    void 곱셈테스트() {
        Calculator cal = new Calculator();
        assertThat(cal.calculate("2 * 3")).isEqualTo(6);
    }

}