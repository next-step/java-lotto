package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperandTest {

    @Test
    void 문자열로_숫자_생성() {
        assertThat(Operand.from("1")).isEqualTo(Operand.from(1));
    }
}