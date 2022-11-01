package calculator;

import calculator.operator.DivideOperator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DivideOperatorTest {

    @Test
    void 양수_양수() {
        assertThat(DivideOperator.getOperator().operate(10, 2)).isEqualTo(5);
        assertThat(DivideOperator.getOperator().operate(2, 10)).isEqualTo(0);
        assertThat(DivideOperator.getOperator().operate(2, 2)).isEqualTo(1);
    }

    @Test
    void 양수_음수() {
        assertThat(DivideOperator.getOperator().operate(10, -2)).isEqualTo(-5);
        assertThat(DivideOperator.getOperator().operate(10, -10)).isEqualTo(-1);
    }

    @Test
    void 음수_양수() {
        assertThat(DivideOperator.getOperator().operate(-1, 2)).isEqualTo(0);
        assertThat(DivideOperator.getOperator().operate(-5, 5)).isEqualTo(-1);
    }

    @Test
    void 음수_음수() {
        assertThat(DivideOperator.getOperator().operate(-1, -2)).isEqualTo(0);
        assertThat(DivideOperator.getOperator().operate(-2, -1)).isEqualTo(2);
    }

    @Test
    void 나누어_떨어지지_않는_경우_결과는_몫() {
        assertThat(DivideOperator.getOperator().operate(10, 3)).isEqualTo(3);
        assertThat(DivideOperator.getOperator().operate(8, 5)).isEqualTo(1);
    }

    @Test
    void 숫자_0으로_나누는_경우() {
        assertThatThrownBy(() -> DivideOperator.getOperator().operate(10, 0));
        assertThatThrownBy(() -> DivideOperator.getOperator().operate(-5, 0));
    }

}
