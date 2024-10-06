package stringCalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    void plus() {
        StringCalculator stringCalculator = new StringCalculator("1", "2", "+");

        int actual = stringCalculator.calculate();

        assertThat(actual).isEqualTo(3);
    }

    @Test
    void minus() {
        StringCalculator stringCalculator = new StringCalculator("2", "1", "-");

        int actual = stringCalculator.calculate();

        assertThat(actual).isEqualTo(1);
    }

    @Test
    void multiply() {
        StringCalculator stringCalculator = new StringCalculator("1", "2", "*");

        int actual = stringCalculator.calculate();

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void divide() {
        StringCalculator stringCalculator = new StringCalculator("2", "1", "/");

        int actual = stringCalculator.calculate();

        assertThat(actual).isEqualTo(2);
    }
}
