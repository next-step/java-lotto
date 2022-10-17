package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MultiplicationOperatorTest {

    private final Operator multiplicationOperator = new MultiplicationOperator();

    @Test
    public void 곱하기_문자를_의미하는_연산자이다() {
        assertTrue(multiplicationOperator.supports("*"));
        assertFalse(multiplicationOperator.supports("%"));
    }

    @Test
    public void 두_값을_곱한_값을_반환한다() {
        Operand operand1 = new Operand(2);
        Operand operand2 = new Operand(3);
        assertThat(multiplicationOperator.operate(operand1, operand2).getValue()).isEqualTo(6);
    }
}
