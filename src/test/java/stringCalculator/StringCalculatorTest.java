package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    @DisplayName("덧셈")
    public void add() {
        assertThat(new Value(6).add(2)).isEqualTo(8);
    }

    @Test
    @DisplayName("뺄셈")
    public void subtract() {
        assertThat(new Value(6).subtract(2)).isEqualTo(4);
    }

    @Test
    @DisplayName("곱셈")
    public void multiply() {
        assertThat(new Value(6).multiply(2)).isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈")
    public void divide() {
        assertThat(new Value(6).divide(2)).isEqualTo(3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    public void nullOrEmpty(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> new StringCalculator(text));
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우")
    public void notFourArithmeticOperations() {
        assertThatIllegalArgumentException().isThrownBy(() -> new StringCalculator("1 @ 2").calculate());
    }

    @Test
    @DisplayName("사칙연산을 모두 포함")
    public void FourArithmeticOperations() {
        assertThat(new StringCalculator("2 + 3 * 4 / 2").calculate()).isEqualTo(10);
    }
}
