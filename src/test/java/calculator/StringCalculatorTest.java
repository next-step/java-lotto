package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 다섯가지_수를_더한다() {
        String input = "1 + 2 + 3 + 4 + 5";
        int result = stringCalculator.calc(input);

        assertThat(result).isEqualTo(15);
    }

    @Test
    void 다섯가지_수를_뺄셈한다() {
        String input = "10 - 3 - 2 - 1 - 0";
        int result = stringCalculator.calc(input);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void 다섯가지_수를_곱셈한다() {
        String input = "1 * 2 * 3 * 4 * 5";
        int result = stringCalculator.calc(input);

        assertThat(result).isEqualTo(120);
    }

    @Test
    void 다섯가지_수를_나눗셈한다() {
        String input = "500 / 2 / 5 / 5 / 2";
        int result = stringCalculator.calc(input);

        assertThat(result).isEqualTo(5);
    }
}
