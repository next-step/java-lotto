package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    void 덧셈이_가능하다() {
        assertThat(Operator.PLUS.executedResult(1, 1)).isEqualTo(2);
    }

}
