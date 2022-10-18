package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberValueTest {

    private NumberValue zero;
    private NumberValue one;
    private NumberValue two;
    private NumberValue three;

    @BeforeEach
    void setUp() {
        zero = new NumberValue(0);
        one = new NumberValue(1);
        two = new NumberValue(2);
        three = new NumberValue(3);
    }

    @Test
    void 덧셈() {
        assertThat(two.plus(one)).isEqualTo(three);
    }

    @Test
    void 뺄셈() {
        assertThat(two.minus(one)).isEqualTo(one);
    }

    @Test
    void 곱셈() {
        assertThat(two.times(one)).isEqualTo(two);
    }

    @Test
    void 나눗셈() {
        assertThat(two.divide(one)).isEqualTo(two);
    }

    @Test
    void 나눗셈_예외() {
        assertThatThrownBy(() -> two.divide(zero))
                .isInstanceOf(ArithmeticException.class);
    }
}
