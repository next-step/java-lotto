package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("빈 문자열을 입력할 경우 0을 반환해야 한다.")
    @Test
    void returnZeroWhenEmptyString() {
        final String emptyString = "";

        int actual = stringCalculator.calculate(emptyString);

        assertThat(actual).isZero();
    }

    @DisplayName("null을 입력할 경우 0을 반환해야 한다.")
    @Test
    void returnZeroWhenNull() {
        int actual = stringCalculator.calculate(null);

        assertThat(actual).isZero();
    }
}