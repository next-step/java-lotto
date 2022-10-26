import calculator.operator.AddOperator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddOperatorTest {

    @Test
    void 양수_양수() {
        assertThat(AddOperator.getOperator().operate(1, 2)).isEqualTo(3);
    }

    @Test
    void 양수_음수() {
        assertThat(AddOperator.getOperator().operate(1, -2)).isEqualTo(-1);
    }

    @Test
    void 음수_음수() {
        assertThat(AddOperator.getOperator().operate(-1, -2)).isEqualTo(-3);
    }
}
