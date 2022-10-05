package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    void 잘못된_연산자는_에러() {
        Assertions.assertThatThrownBy(() -> Operator.from("%"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}