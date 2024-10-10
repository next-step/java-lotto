package calculator.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdditionTest {
    @Test
    void 덧셈_연산() {
        OperationStrategy operationStrategy = Addition.getInstance();
        assertThat(operationStrategy.calculate(1, 2)).isEqualTo(3);
    }
}