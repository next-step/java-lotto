package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    // 안되는 이유?
    @Test
    void 덧셈() {
        assertThat(Operator.operatorOf("+")).isEqualTo(new Add());
    }

    @Test
    void 뺄셈() {
        assertThat(Operator.operatorOf("-")).isEqualTo(new Subtract());
    }
}
