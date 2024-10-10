package calculator.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {
    @Test
    void 뺄셈_연산() {
        OperationStrategy operationStrategy = Subtraction.getInstance();
        assertThat(operationStrategy.calculate(10, 2)).isEqualTo(8);
    }
}