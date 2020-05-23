package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperandTest {

    @DisplayName("음수를 Operand로 변환 시 Exception을 던진다")
    @Test
    void negative() {
        assertThatThrownBy(() -> new Operand("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수인 -1는 더할 수 없습니다");
    }

    @DisplayName("문자를 Operand로 변환시도 시 Exception을 던진다")
    @Test
    void stringToOperand() {
        assertThatThrownBy(() -> new Operand("하"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 하는 더할 수 없습니다");
    }
}