package calculator;

import org.junit.jupiter.api.Test;

import static calculator.utils.Calculator.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void 덧셈() {
        assertThat(plus(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(minus(2, 1)).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        assertThat(multiply(2, 1)).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        assertThat(divide(2, 1)).isEqualTo(2);
    }
}
