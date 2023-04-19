package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    void 덧셈() {
        assertThat(StringCalculator.sum(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(StringCalculator.substring(1, 2)).isEqualTo(-1);
    }
}
