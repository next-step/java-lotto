package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    // 안되는 이유?
    @Test
    void 연산() {
        assertThat(Operator.operatorOf("+")).isEqualTo(new Add());
    }
}
