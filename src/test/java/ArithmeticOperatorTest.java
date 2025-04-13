import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

class ArithmeticOperatorTest {

    @Test
    void createOperator_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> ArithmeticOperator.from("$"));
    }

    @Test
    void PlusOperator() {
        assertThat(ArithmeticOperator.from("+")).isEqualTo(ArithmeticOperator.PLUS);
    }

    @Test
    void MinusOperator() {
        assertThat(ArithmeticOperator.from("-")).isEqualTo(ArithmeticOperator.MINUS);
    }

    @Test
    void MultiplyOperator() {
        assertThat(ArithmeticOperator.from("*")).isEqualTo(ArithmeticOperator.MULTIPLY);
    }

    @Test
    void DivisionOperator() {
        assertThat(ArithmeticOperator.from("/")).isEqualTo(ArithmeticOperator.DIVIDE);
    }
}
