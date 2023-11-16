package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;
    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
    }
    @Test
    void plus() {
        assertThat(stringCalculator.calculate("2 + 3")).isEqualTo(5);
    }

    @Test
    void minus() {
        assertThat(stringCalculator.calculate("2 - 3")).isEqualTo(-1);
    }
}
