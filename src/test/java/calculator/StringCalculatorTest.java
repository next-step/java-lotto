package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void createStringCalculator() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 덧셈() {
        assertThat(stringCalculator.plus(1, 2)).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        assertThat(stringCalculator.minus(2, 1)).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        assertThat(stringCalculator.multiply(2, 1)).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        assertThat(stringCalculator.divide(2, 1)).isEqualTo(2);
    }

}
