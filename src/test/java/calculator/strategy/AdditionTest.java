package calculator.strategy;

import calculator.domain.Operand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionTest {
    @Test
    void 덧셈_연산() {
        Operand left = new Operand("1");
        Operand right = new Operand("2");
        OperationStrategy operationStrategy = Addition.getInstance();

        assertThat(operationStrategy.calculate(left, right)).isEqualTo(new Operand("3"));
    }
}