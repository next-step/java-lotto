package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    void calculate() {
        String inputFormular = "1 + 2 * 3 / 2 - 1";

        assertThat(StringCalculator.calculate(inputFormular)).isEqualTo(3);
    }
}
