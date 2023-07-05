package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubtractionTest {
    @Test
    @DisplayName("subtraction 연산 확인")
    void testCalculate() {
        // given
        Subtraction subtraction = new Subtraction();
        int num1 = 5;
        int num2 = 3;

        // when
        int result = subtraction.calculate(num1, num2);

        // then
        assertThat(result).isEqualTo(2);
    }
}
