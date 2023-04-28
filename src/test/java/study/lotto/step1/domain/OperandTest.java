package study.lotto.step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OperandTest {
    @Test
    void invalid_operand_then_throw_IllegalArgumentException() {
        // given
        String invalidOperand = "1.2.3";

        // when, then
        assertThatThrownBy(() -> new Operand(invalidOperand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 피연산자가 아닙니다: " + invalidOperand);
    }
}