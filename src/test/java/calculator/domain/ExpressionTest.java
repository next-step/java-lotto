package calculator.domain;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {

    @Test
    void Operand_리스트가_null_또는_비어있는_경우_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(null, List.of(Operator.PLUS)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(List.of(), List.of(Operator.PLUS)));
    }

    @Test
    void Operator_리스트가_null인_경우_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(List.of(new Operand("3")), null));
    }
}
