package string;

import org.junit.jupiter.api.Test;
import string.Operator;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void 덧셈() {
        assertThat(Operator.operatorOf("+")).isEqualTo(Operator.ADD);
    }

    @Test
    void 뺄셈() {
        assertThat(Operator.operatorOf("-")).isEqualTo(Operator.SUBTRACT);
    }

    @Test
    void 곱셈() {
        assertThat(Operator.operatorOf("*")).isEqualTo(Operator.MULTIPLE);
    }

    @Test
    void 나눗셈() {
        assertThat(Operator.operatorOf("/")).isEqualTo(Operator.DIVIDE);
    }

    @Test
    void 덧셈_연산() {
        assertThat(Operator.ADD.operate(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈_연산() {
        assertThat(Operator.SUBTRACT.operate(2, 1)).isEqualTo(1);
    }

    @Test
    void 곱셈_연산() {
        assertThat(Operator.MULTIPLE.operate(1, 2)).isEqualTo(2);
    }

    @Test
    void 나눗셈_연산() {
        assertThat(Operator.DIVIDE.operate(10, 2)).isEqualTo(5);
    }
}
