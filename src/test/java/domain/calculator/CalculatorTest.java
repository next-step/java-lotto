package domain.calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void getOperationResultTest() {
        Calculator calculator = new Calculator();

        assertThat(calculator.testMethod("+", 1, 2)).isEqualTo(3);
        assertThat(calculator.testMethod("-", 1, 2)).isEqualTo(-1);
        assertThat(calculator.testMethod("*", 1, 2)).isEqualTo(2);
        assertThat(calculator.testMethod("/", 1, 2)).isEqualTo(0);
    }
}
