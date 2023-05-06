package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    void testPlus() {
        //arrange
        String input = "1 + 4 + 7";

        //act
        int result = StringCalculator.calculate(input);

        //assert
        assertThat(result).isEqualTo(12);
    }
}
