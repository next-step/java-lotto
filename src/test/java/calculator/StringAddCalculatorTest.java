package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    void calculate_inputIsEmpty_return0() {
        int result = StringAddCalculator.calculate("");
        assertThat(result).isZero();

        result = StringAddCalculator.calculate(null);
        assertThat(result).isZero();
    }
}
