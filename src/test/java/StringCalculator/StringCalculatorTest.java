package StringCalculator;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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

    @Test
    void 나눗기() {
        String input = "4 / 4";
        int expected = 1;
        int result = StringCalculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 나눗기_정수값으로_떨어짐() {
        String input =  "5 / 4";
        int expected = 1;
        int result = StringCalculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 곱하기() {
        String input = "4 * 4";
        int expected = 16;
        int result = StringCalculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 입력값이_null_예외발생() {
        String input = null;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(input));
    }

    @Test
    void 입력값이_빈공백문자이면_예외발생() {
        String input = "";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> StringCalculator.calculate(input));
    }
}