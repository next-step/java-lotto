package calculator;

import calculator.operation.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("operation 을 곱셈으로 변경하면 Calculator 의 operation 이 곱셈으로 변경된다.")
    void changeOperation() {
        Calculator calculator = new Calculator(new AddOperation());

        Operation operation = new MultiplyOperation();
        calculator.changeOperation(operation);

        assertThat(calculator).isEqualTo(new Calculator(operation));
    }
}
