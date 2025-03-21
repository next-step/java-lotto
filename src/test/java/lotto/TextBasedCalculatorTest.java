package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextBasedCalculatorTest {
    @Test
    void validate_input() {
        assertThat(TextBasedCalculator.validate("11 22 +")).isFalse();
        assertThat(TextBasedCalculator.validate("+ 11 - 22")).isFalse();
        assertThat(TextBasedCalculator.validate("11 - 22 / 0")).isFalse();
        assertThat(TextBasedCalculator.validate("11 - 22 / -0")).isFalse();
        assertThat(TextBasedCalculator.validate("11 - 22 / 1")).isTrue();
        assertThat(TextBasedCalculator.validate("-11 - 22 / 1")).isTrue();
    }
}
