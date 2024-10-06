package calculator.domain.calculator;

import calculator.domain.Calculable;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumCalculatorTest {

    @Test
    void 더하기() {
        Calculable cal = new SumCalculator();
        int preResult = 10;
        int operand = 10;

        assertThat(cal.calculate(preResult, operand)).isEqualTo(20);
    }
}
