package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OperationStrategyTest {
    @Test
    @DisplayName("덧셈 테스트")
    void operationAdd() {
        OperationStrategy operationStrategy = new OperationStrategyAdd();
        int input = operationStrategy.operate(1, 2);

        assertThat(input).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void operationSubtract() {
        OperationStrategy operationStrategy = new OperationStrategySubtract();
        int input = operationStrategy.operate(1, 2);

        assertThat(input).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void operationMultiply() {
        OperationStrategy operationStrategy = new OperationStrategyMultiply();
        int input = operationStrategy.operate(1, 2);

        assertThat(input).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void operationDivide() {
        OperationStrategy operationStrategy = new OperationStrategyDivide();
        int input = operationStrategy.operate(6, 2);

        assertThat(input).isEqualTo(3);
    }
}
