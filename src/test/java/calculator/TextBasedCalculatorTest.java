package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TextBasedCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"11 22 +", "+ 11 - 22", "11 - 22 / 0", " "})
    void invalidate_format(String input) {
        assertThatThrownBy(() -> TextBasedCalculator.calculate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "11 - 22", "11 - 22 / 1", "-11 - 22 / 2"})
    void validate_format(String input) {
        assertThat(TextBasedCalculator.calculate(input)).isNotNull();
    }

    @Test
    void test_calculate() {
        assertThat(TextBasedCalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(new NumberToken(10));
    }
}
