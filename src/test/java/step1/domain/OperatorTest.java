package step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    void 덧셈() {
        assertThat(Operator.calculate(4, "+", 2)).isEqualTo(6);
    }

    @Test
    void 뺄셈() {
        assertThat(Operator.calculate(4, "-", 2)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(Operator.calculate(4, "*", 2)).isEqualTo(8);
    }

    @Test
    void 나눗셈() {
        assertThat(Operator.calculate(4, "/", 2)).isEqualTo(2);
    }

}