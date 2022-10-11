package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    void 잘못된_연산자는_에러() {
        assertThatThrownBy(() -> Operator.from("%"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영으로_나누면_에러() {
        assertThatThrownBy(() -> Operator.DIVIDE.operate(Operand.from( 3), Operand.from(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 피연산자는_들어올_수_없다() {
        assertThat(Operator.isOperator("3")).isFalse();
    }
}