package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("덧셈 테스트")
    void testPlus() {
        //arrange
        String input = "1 + 4 + 7";

        //act
        int result = StringCalculator.calculate(input);

        //assert
        assertThat(result).isEqualTo(12);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void testMinus() {
        //arrange
        String input = "1 - 4 - 7";

        //act
        int result = StringCalculator.calculate(input);

        //assert
        assertThat(result).isEqualTo(-10);
    }
}
