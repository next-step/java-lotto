package study.lotto.step1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OperatorsTest {
    @Test
    @DisplayName("첫번째 피연산자 반환 후 삭제")
    void remove_first() {
        // given
        Operators operators = new Operators(new ArrayDeque<>(List.of(Operator.ADD, Operator.DIVIDE)));

        // when
        Operator removedOperator = operators.removeFirst();

        // then
        assertThat(removedOperator).isEqualTo(Operator.ADD);
    }
}