package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DivisionOperatorTest {

    private final Operator divisionOperator = new DivisionOperator();

    @Test
    public void 나누기_문자를_의미하는_연산자이다() {
        assertTrue(divisionOperator.supports("/"));
        assertFalse(divisionOperator.supports("%"));
    }

    @Test
    public void 두_값을_나눈_값을_반환한다() {
        Operand operand1 = new Operand(4);
        Operand operand2 = new Operand(2);
        assertThat(divisionOperator.operate(operand1, operand2).getValue()).isEqualTo(2);
    }
}
