import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void 덧셈() {
        int result = calculator.calculate("1 + 1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 뺄셈() {
        int result = calculator.calculate("1 - 1");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 곱셈() {
        int result = calculator.calculate("1 * 1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 나눗셈() {
        int result = calculator.calculate("3 / 2");
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void 입력값이null이거나_빈공백문자일경우_IllegalArgumentException을_throw한다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ! 1", "1 ^ 1", "1 # 1"})
    public void 사칙연산기호가_아닌경우_IllegalArgumentException을_throw한다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
    }

    @Test
    public void 사칙연산의_계산우선순위가아닌_입력값에따라_계산순서가결정된다() {
        int result = calculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}
