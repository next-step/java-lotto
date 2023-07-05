package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationTest {
    @Test
    @DisplayName("multiplication 연산 확인")
    void testCalculate() {
        // given
        Multiplication multiplication = new Multiplication();
        int num1 = 2;
        int num2 = 3;

        // when
        int result = multiplication.calculate(num1, num2);

        // then
        assertThat(result).isEqualTo(6);
    }
}
