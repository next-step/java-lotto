package StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {


    @Test
    void 더하기() {
        String input = "3 + 5";
        int expected = 8;
        int result = StringCalculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }
}