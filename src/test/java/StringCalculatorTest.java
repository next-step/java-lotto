import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    @DisplayName("더하가")
    void add() {
        String input = "1 + 1";
        StringCalculator calculator = new StringCalculator();
        int result= calculator.add(input);
        assertThat(result).isEqualTo(2);
    }
}
