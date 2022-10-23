package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {
    @Test
    void test_parsing() {
        assertThat(new Number("3")).isEqualTo(new Number(3));
    }

    @Test
    void test_plus() {
        assertThat(new Number(3).plus(new Number(4))).isEqualTo(new Number(7));
    }

    @Test
    void test_minus() {
        assertThat(new Number(3).minus(new Number(4))).isEqualTo(new Number(-1));
    }

    @Test
    void test_multiply() {
        assertThat(new Number(3).multiply(new Number(4))).isEqualTo(new Number(12));
    }

    @Test
    void test_divide() {
        assertThat(new Number(7).divide(new Number(4))).isEqualTo(new Number(1));
    }
}
