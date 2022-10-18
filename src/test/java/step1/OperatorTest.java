package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    void 덧셈이_가능하다() {
        assertThat(Operator.PLUS.executedResult(1, 1)).isEqualTo(2);
    }

    @Test
    void 뺄셈이_가능하다() {
        assertThat(Operator.MINUS.executedResult(1, 1)).isZero();
    }

    @Test
    void 곱셈이_가능하다() {
        assertThat(Operator.MULTIPLY.executedResult(1, 1)).isOne();
    }

    @Test
    void 나눗셈이_가능하다() {
        assertThat(Operator.DIVIDE.executedResult(1, 1)).isOne();
    }

}
