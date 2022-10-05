import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    @DisplayName("연산자가 아닌 입력이 들어올 경우 예외 발생")
    public void input_right_operator_test() {
        assertThatThrownBy(() -> Operator.findOperator("?"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 수식입니다.");
    }
}