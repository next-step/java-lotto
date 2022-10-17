import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    void plus() {
        String str = "1 + 1 + 3";
        assertThat(Calculator.calculate(str)).isEqualTo(5);
    }

    @Test
    void minus() {
        String str = "2 - 1";
        assertThat(Calculator.calculate(str)).isEqualTo(1);
    }

    @Test
    void multiply() {
        String str = "2 * 3";
        assertThat(Calculator.calculate(str)).isEqualTo(6);
    }

    @Test
    void division() {
        String str = "6 / 2";
        assertThat(Calculator.calculate(str)).isEqualTo(3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", " "})
    void inputNull(String str) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(str));
    }

    @Test
    void badSymbolRequest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate("4 { 6"));
    }

    @Test
    void allSymbol() {
        String str = "1 + 3 * 5 / 4 - 1";
        assertThat(Calculator.calculate(str)).isEqualTo(4);
    }
}
