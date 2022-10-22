package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "  "})
    void test_empty_string(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator(value));
    }

    @Test
    void test_invalid_operator() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator("2 . 3").calculate());
    }

    @ParameterizedTest
    @CsvSource({"2,2","2 + 3,5", "3 - 2,1", "2 * 3,6", "8 / 3,2", "2 + 3 * 4 / 2,10"})
    void test_calculate(String expr, int result) {
        assertThat(new Calculator(expr).calculate()).isEqualTo(new Number(result));
    }
}
