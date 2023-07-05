package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionTest {
    @Test
    @DisplayName("addition 연산 확인")
    void testCalculate() {
        // given
        Addition addition = new Addition();
        int num1 = 2;
        int num2 = 3;

        // when
        int result = addition.calculate(num1, num2);

        // then
        assertThat(result).isEqualTo(5);
    }
}
