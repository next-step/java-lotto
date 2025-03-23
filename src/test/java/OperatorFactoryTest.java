import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class OperatorFactoryTest {

    @Test
    void createOperator_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> OperatorFactory.createOperator("$"));
    }

    @Test
    void PlusOperator() {
        assertThat(OperatorFactory.createOperator("+")).isInstanceOf(PlusOperator.class);
    }

    @Test
    void MinusOperator() {
        assertThat(OperatorFactory.createOperator("-")).isInstanceOf(MinusOperator.class);
    }

    @Test
    void MultiplyOperator() {
        assertThat(OperatorFactory.createOperator("*")).isInstanceOf(MultiplicationOperator.class);
    }

    @Test
    void DivisionOperator() {
        assertThat(OperatorFactory.createOperator("/")).isInstanceOf(DivisionOperator.class);
    }
}
