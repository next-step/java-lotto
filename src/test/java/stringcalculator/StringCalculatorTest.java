package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringCalculatorTest {

    @Test
    void add() {
        assertThat(StringCalculator.add(3, 5)).isEqualTo(8);
    }
}
