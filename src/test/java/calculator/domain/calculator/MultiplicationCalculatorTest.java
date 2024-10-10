package calculator.domain.calculator;

import calculator.domain.Calculable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationCalculatorTest {

    @Test
    void 곱하기() {
        Calculable cal = new MultiplicationCalculator();
        int preResult = 10;
        int operand = 10;

        assertThat(cal.calculate(preResult, operand)).isEqualTo(100);
    }
}
