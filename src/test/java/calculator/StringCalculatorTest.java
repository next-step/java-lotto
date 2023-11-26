package calculator;

import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void split() {
        assertThat(getSplit("1 + 2")).containsExactly("1", "+", "2");
    }

    @Test
    void 덧셈() {
        assertThat(plus("1 + 2")).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(minus("3 - 1")).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(multiply("3 * 2")).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(divide("6 / 2")).isEqualTo(3);
    }

}
