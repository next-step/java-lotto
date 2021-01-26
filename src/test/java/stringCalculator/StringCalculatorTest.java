package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import stringCalculator.domain.StringCalculator;

class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

}
