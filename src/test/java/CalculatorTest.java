import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    @DisplayName("null or 빈값 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void emptyInput(String input) {
        assertThatThrownBy(() -> {
            Calculator calculator = new Calculator();
            calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산 테스트")
    void calculate() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("1 + 2 * 4 / 2");
        assertThat(result).isEqualTo(6);
    }
}
