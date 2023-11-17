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

    @Test
    void multiply() {
        assertThat(stringCalculator.calculate("2 * 3")).isEqualTo(6);
    }
    @Test
    void divide() {
        assertThat(stringCalculator.calculate("2 / 3")).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 문자열의 총합을 구할 수 있다")
    void sum() {
        assertThat(stringCalculator.calculate("2 + 4 - 3 * 5 / 2")).isEqualTo(8);
    }
}
