import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2", "2 - 1:1", "4 / 2:2", "3 * 3:9"}, delimiter = ':')
    public void calculationTest(String expression, int expected) {
        assertThat(calculateResult(expression)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    public void NullOrEmptyTest(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculateResult(expression));
    }

    private int calculateResult(String expression) {
        String[] numbersAndOps = expression.split(" ");
        return new Calculator(numbersAndOps).calculate();
    }
}
