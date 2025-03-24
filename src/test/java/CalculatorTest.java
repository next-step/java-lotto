import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("두 개의 숫자로 이루어진 덧셈을 할 수 있다.")
    void additionTest() {
        Calculator calculator = new Calculator();
        CalculatorInput input = new CalculatorInput("2 + 3");
        assertThat(calculator.calculate(input)).isEqualTo(5);
    }
}
