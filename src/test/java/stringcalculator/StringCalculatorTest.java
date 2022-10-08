package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringCalculatorTest {

    @Test
    void add() {
        assertThat(StringCalculator.add(new Number("3"), 5)).isEqualTo(new Number("8"));
    }

    @Test
    void minus() {
        assertThat(StringCalculator.minus(new Number("5"), 2)).isEqualTo(new Number("3"));
    }

    @Test
    void multiply() {
        assertThat(StringCalculator.multiply(new Number("5"), 2)).isEqualTo(new Number("10"));
    }

    @Test
    void division() {
        assertThat(StringCalculator.division(new Number("6"), 2)).isEqualTo(new Number("3"));
    }
}
