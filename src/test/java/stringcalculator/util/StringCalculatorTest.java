package stringcalculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    @DisplayName("두 수를 더한다.")
    void add() {
        assertThat(StringCalculator.add(1, 3)).isEqualTo(4);
    }

}
