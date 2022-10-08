import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    @DisplayName("계산한다")
    void calculate() {
        String input = "2 + 3 * 4 / 2";
        StringCalculator calculator = new StringCalculator(new InputValue(input));
        int result = calculator.Calculate(input);
        assertThat(result).isEqualTo(10);
    }

}
