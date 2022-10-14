package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void 덧셈() {
        assertThat(Operator.operatorOf("+")).isEqualTo(new Add());
    }

    @Test
    void 뺄셈() {
        assertThat(Operator.operatorOf("-")).isEqualTo(new Subtract());
    }

    @Test
    void 곱셈() {
        assertThat(Operator.operatorOf("*")).isEqualTo(new Multiple());
    }

    @Test
    void 나눗셈() {
        assertThat(Operator.operatorOf("/")).isEqualTo(new Divide());
    }
}
