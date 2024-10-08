package calculator.strategy;

import calculator.domain.Operand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {
    @Test
    void 뺄셈_연산() {
        Operand left = new Operand("10");
        Operand right = new Operand("2");
        OperationStrategy operationStrategy = Subtraction.getInstance();

        assertThat(operationStrategy.calculate(left, right)).isEqualTo(new Operand("8"));
    }
}