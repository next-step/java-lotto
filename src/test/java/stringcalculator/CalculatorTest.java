package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("덧셈 연산을 요청할 때, 덧셈 결과를 반환해야 한다.")
    @Test
    void calculate() {
        CalculatorRequest request = new CalculatorRequest(
                List.of(1, 2),
                List.of(ArithmeticOperator.PLUS)
        );
        assertThat(Calculator.calculate(request)).isEqualTo(3);
    }

}
