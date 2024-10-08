package calculator.strategy;

import calculator.domain.Operand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivisionTest {
    @Test
    void 나눗셈_연산() {
        Operand left = new Operand("1");
        Operand right = new Operand("1");
        OperationStrategy operationStrategy = Division.getInstance();

        assertThat(operationStrategy.calculate(left, right)).isEqualTo(new Operand("1"));
    }
}