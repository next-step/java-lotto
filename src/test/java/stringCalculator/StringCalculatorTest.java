package stringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    @Test
    void add() {
        int result = StringCalculator.splitAndCalculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtract() {
        int result = StringCalculator.splitAndCalculate("3 - 2");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void multiply() {
        int result = StringCalculator.splitAndCalculate("3 * 2");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void divide() {
        int result = StringCalculator.splitAndCalculate("6 / 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 사칙연산_모두_포함() {
        int result = StringCalculator.splitAndCalculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    void inputIsNullOrBlank() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                StringCalculator.splitAndCalculate(null));

        assertThatIllegalArgumentException().isThrownBy(() ->
                StringCalculator.splitAndCalculate(""));
    }
}
