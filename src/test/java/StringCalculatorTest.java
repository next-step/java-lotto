import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {
    @Test
    void splitString() {
        final StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.split("1 * 2 + 3")).containsExactly("1", "*", "2", "+", "3");
    }

    @ParameterizedTest
    @CsvSource(value = { "1 + 2,3", "2 - 1,1", "3 * 2,6", "4 / 2,2" }, delimiter = ',')
    void calculate() {
        final StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate("1", "2", "+")).isEqualTo(3);
    }

    @Test
    void calculateString() {
        final StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculateString("2 + 3 * 4 / 2 - 1")).isEqualTo(9);
    }

    @Test
    void calculateString_illegalArgumentException() {
        final StringCalculator stringCalculator = new StringCalculator();
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculateString("2 $ 3"));
    }
}
