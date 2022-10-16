package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void 덧셈() {
        assertThat(Operator.operatorOf("+")).isInstanceOf(Add.class);
    }

    @Test
    void 뺄셈() {
        assertThat(Operator.operatorOf("-")).isInstanceOf(Subtract.class);
    }

    @Test
    void 곱셈() {
        assertThat(Operator.operatorOf("*")).isInstanceOf(Multiple.class);
    }

    @Test
    void 나눗셈() {
        assertThat(Operator.operatorOf("/")).isInstanceOf(Divide.class);
    }
}
