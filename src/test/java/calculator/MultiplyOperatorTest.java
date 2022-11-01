package calculator;

import calculator.operator.MultiplyOperator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplyOperatorTest {

    @Test
    void 둘중_0이_포함() {
        assertThat(MultiplyOperator.getOperator().operate(10, 0)).isEqualTo(0);
        assertThat(MultiplyOperator.getOperator().operate(0, -5)).isEqualTo(0);
    }

    @Test
    void 양수_양수() {
        assertThat(MultiplyOperator.getOperator().operate(10, 2)).isEqualTo(20);
        assertThat(MultiplyOperator.getOperator().operate(1, 5)).isEqualTo(5);
    }

    @Test
    void 양수_음수() {
        assertThat(MultiplyOperator.getOperator().operate(1, -2)).isEqualTo(-2);
        assertThat(MultiplyOperator.getOperator().operate(10, -3)).isEqualTo(-30);
    }

    @Test
    void 음수_음수() {
        assertThat(MultiplyOperator.getOperator().operate(-1, -2)).isEqualTo(2);
        assertThat(MultiplyOperator.getOperator().operate(-3, -2)).isEqualTo(6);
    }

}
