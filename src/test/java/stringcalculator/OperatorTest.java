package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    void 덧셈() {
        int actual = Operator.add(1, 3);
        assertThat(actual).isEqualTo(4);
    }

    @Test
    void 뺄셈() {
        int actual = Operator.minus(5, 3);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        int actual = Operator.multiply(3, 5);
        assertThat(actual).isEqualTo(15);
    }

    @Test
    void 나눗셈() {
        int actual = Operator.division(10, 5);
        assertThat(actual).isEqualTo(2);
    }
}
