package lotto.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    @DisplayName("덧셈")
    void add() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate("2 + 5");
        assertThat(result).isEqualTo(7);
    }
    
    @Test
    @DisplayName("뺄셈")
    void subtract() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate("2 - 5");
        assertThat(result).isEqualTo(-3);
    }
    
    @Test
    @DisplayName("곱셈")
    void multiply() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate("2 * 5");
        assertThat(result).isEqualTo(10);
    }
}
