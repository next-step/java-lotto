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

}
