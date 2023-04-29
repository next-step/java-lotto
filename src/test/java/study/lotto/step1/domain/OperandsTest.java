package study.lotto.step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OperandsTest {
    @Test
    @DisplayName("첫번째 피연산자 반환 후 삭제")
    void remove_first() {
        // given
        Operand firstOperand = new Operand("3");
        Operand secondOperand = new Operand("4");
        Operands operands = new Operands(new ArrayDeque<>(List.of(firstOperand, secondOperand)));

        // when
        Operand removedOperand = operands.removeFirst();

        // then
        assertThat(removedOperand).isEqualTo(firstOperand);
        assertThat(operands.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("피연산자를 첫번째 인덱스에 삽입")
    void add_first() {
        // given
        Operand firstOperand = new Operand("3");
        Operands operands = new Operands(new ArrayDeque<>(List.of(firstOperand)));

        // when
        Operand addedOperand = new Operand("4");
        operands.addFirst(addedOperand);

        // then
        assertThat(operands.size()).isEqualTo(2);
        assertThat(operands.removeFirst()).isEqualTo(addedOperand);
    }
}