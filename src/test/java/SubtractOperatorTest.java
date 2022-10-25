import calculator.operator.SubtractOperator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractOperatorTest {

    @Test
    void 큰수_작은수() {
        assertThat(SubtractOperator.getOperator().operate(10, 2)).isEqualTo(8);
        assertThat(SubtractOperator.getOperator().operate(-1, -5)).isEqualTo(4);
    }

    @Test
    void 작은수_큰수() {
        assertThat(SubtractOperator.getOperator().operate(1, 2)).isEqualTo(-1);
        assertThat(SubtractOperator.getOperator().operate(-10, -2)).isEqualTo(-8);
    }

}
