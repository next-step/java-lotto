package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperandTest {

    @Test
    void 영으로_나누면_에러() {
        assertThatThrownBy(() -> Operand.from(2)
                .divide(Operand.from(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}