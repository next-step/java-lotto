package calculator.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplicationTest {
    @Test
    void 곱셈_연산() {
        OperationStrategy operationStrategy = Multiplication.getInstance();
        assertThat(operationStrategy.calculate(1, 2)).isEqualTo(2);
    }
}