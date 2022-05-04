package calculator.domain;

import calculator.domain.operation.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    @DisplayName("operation 을 곱셈으로 변경하면 Calculator 의 operation 이 곱셈으로 변경된다.")
    void changeOperation() {
        Operator operator = new Operator(new AddOperation());

        Operation operation = new MultiplyOperation();
        operator.changeOperation(operation);

        assertThat(operator).isEqualTo(new Operator(operation));
    }
}
