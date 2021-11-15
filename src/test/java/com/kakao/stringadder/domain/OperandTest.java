package com.kakao.stringadder.domain;

import com.kakao.stringadder.domain.calculator.Operand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OperandTest {

    @Test
    @DisplayName("음수를 Operand 로 넣으면 에러가 발생한다.")
    void negativeOperand() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Operand(-1));
    }

    @Test
    @DisplayName("Operand 끼리 덧셈이 가능하다.")
    void plusOperand() {
        Operand operand1 = new Operand(1);
        Operand operand2 = new Operand(2);
        assertThat(operand1.plus(operand2)).isEqualTo(new Operand(3));
    }

    @Test
    @DisplayName("문자열로 Operand 생성이 가능하다.")
    void operandString() {
        assertThat(Operand.of("1")).isEqualTo(new Operand(1));
    }

    @Test
    @DisplayName("잘못된 문자열의 Operand를 넣을 경우 에러가 발생한다.")
    void operandStringError() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operand.of(",1;"));
    }
}
