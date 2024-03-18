import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("입력 1 + 3 - 3 || 출력 1")
    @Test
    void calculator_three_numbers() {
        String input = "1 + 3 - 3";
        assertThat(new Calculator().calculate(input)).isEqualTo(1);
    }

    @DisplayName("입력 1 + 3 || 출력 4")
    @Test
    void add() {
        String input = "1 + 3";
        assertThat(new Calculator().calculate(input)).isEqualTo(4);
    }

}
