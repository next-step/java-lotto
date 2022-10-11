package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperandTest {

    @Test
    void 문자열로_숫자_생성() {
        assertThat(Operand.from("1")).isEqualTo(Operand.from(1));
    }

    @Test
    void 연산자는_들어올_수_없다() {
        assertThat(Operand.isOperand("*"))
                .isFalse();
    }
}