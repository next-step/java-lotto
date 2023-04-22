import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2=10",
            "22 + 3 / 4 * 2=12",
            "2 + 3 * 1 / 10=0",
            "2 + 3 * -4 / 2=-10"
    }, delimiter = '=')
    @DisplayName("올바른 사칙연산에선 정확한 결과를 반환해야 한다")
    public void validExpression(String expression, int expected) {
        int result = Calculator.calculate(expression);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 `null`이거나 없으면 예외가 난다")
    public void emptyOrNull(String expression) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(expression));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 & 3", "@", "2 ! 12", "2 +- 5", "*/"})
    @DisplayName("사칙연산 기호가 아닌 경우 예외가 난다")
    public void invalidOperation(String expression) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(expression));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2 + 3 * / 2",
            "2 + * * 4 / 2",
    })
    @DisplayName("올바른 연산 형식이 아니면 예외가 난다")
    public void inValidExpression(String expression) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Calculator.calculate(expression));

    }
}