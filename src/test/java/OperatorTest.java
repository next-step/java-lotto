import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    void 사칙연산_기호가_아닌_경우_IllegalArgumentException() {
        // given
        String invalidValue = "(";

        // when then
        assertThatThrownBy(() -> Operator.valueByOperation(invalidValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
