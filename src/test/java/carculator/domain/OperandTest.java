package carculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class OperandTest {

    @Test
    @DisplayName("계산 대상이 되는 값은 null이면 예외가 발생한다.")
    public void operandNullTest() {
        assertThatNullPointerException()
                .isThrownBy(() -> new Operand(null));
    }

    @Test
    @DisplayName("계산 대상이 되는 값은 음수가 될 수 없다.")
    public void operandNegativeTest() {
        assertThatIllegalArgumentException()
        .isThrownBy(() -> new Operand(-1));
    }

    @Test
    @DisplayName("계산 대산이 되는 값은 0이 될 수 없다.")
    public void operandZeroTest() {
        assertThatIllegalArgumentException()
        .isThrownBy(() -> new Operand(0));
    }
}
