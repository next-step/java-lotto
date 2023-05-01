package calculator.domain;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {

    @Test
    void Operand_리스트가_null_또는_비어있는_경우_IllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Expression(null, List.of(Operator.PLUS)));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Expression(List.of(), List.of(Operator.PLUS)));
    }

    @Test
    void Operator_리스트가_null인_경우_IllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Expression(List.of(new Operand(new Number(3))), null));
    }

    @Test
    void calculate() {
        Operand operand1 = new Operand(new Number(3));
        Operand operand2 = new Operand(new Number(3));
        Operand operand3 = new Operand(new Number(5));
        List<Operand> operands = List.of(operand1, operand2, operand3);
        List<Operator> operators = List.of(Operator.PLUS, Operator.MULTIPLY);
        Expression expression = new Expression(operands, operators);
        assertThat(expression.calculate()).isEqualTo(new Number(30));
    }
}
