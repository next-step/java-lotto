package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void unaryEquationGiven_ReturnAnswer() {
        assertThat(new StringCalculator().calculate(new Equation("2 + 3"))).isEqualTo(5);
    }
}
