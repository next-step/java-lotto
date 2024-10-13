package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void testStringCalculator() {
        assertThat(StringCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("입력이 비어있을 경우 예외발생")
    void testBlankString() {
        assertThatThrownBy(() -> {
            StringCalculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            StringCalculator.calculate("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
