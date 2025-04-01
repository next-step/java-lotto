package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @Test
    public void add() {
        int result = StringCalculator.calculate("1 + 2 + 3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void subtract() {
        int result = StringCalculator.calculate("10 - 2 - 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void multiply() {
        int result = StringCalculator.calculate("2 * 3 * 4");
        assertThat(result).isEqualTo(24);
    }

    @Test
    public void divide() {
        int result = StringCalculator.calculate("10 / 2");
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void blankInput(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(input));
    }


}
