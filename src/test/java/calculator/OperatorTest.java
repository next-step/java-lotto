package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    void 잘못된_연산자는_에러() {
        Assertions.assertThatThrownBy(() -> Operator.from("%"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영으로_나누면_에러() {
        assertThatThrownBy(() -> Operator.DIVIDE.operate(3, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}