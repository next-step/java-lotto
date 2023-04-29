package study.lotto.step1.application.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.step1.domain.Operand;
import study.lotto.step1.domain.Operands;
import study.lotto.step1.domain.Operator;
import study.lotto.step1.domain.Operators;

import java.util.List;

class ExpressionParserTest {
    @Test
    @DisplayName("수식에서 Operands 객체 생성")
    void operands() {
        // given
        String expression = "1 + 2 * 3";

        // when
        Operands operands = ExpressionParser.operands(expression);

        // then
        Operands expectedOperands = new Operands(List.of(new Operand("1"), new Operand("2"), new Operand("3")));
        Assertions.assertThat(operands).isEqualTo(expectedOperands);
    }

    @Test
    @DisplayName("수식에서 Operators 객체 생성")
    void operators() {
        // given
        String expression = "1 + 2 * 3";

        // when
        Operators operands = ExpressionParser.operators(expression);

        // then
        Operators expectedOperators = new Operators(List.of(Operator.ADD, Operator.MULTIPLY));
        Assertions.assertThat(operands).isEqualTo(expectedOperators);
    }
}