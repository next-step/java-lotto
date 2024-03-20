package StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @Test
    void 빼기() {
        String input = "3 - 5";
        int expected = -2;
        int result = StringCalculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 연산자가_없으면_예외발생() {
        String input = "3 5";
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}