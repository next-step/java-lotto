package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @DisplayName("입력값은 null이거나 공백일 수 없다.")
    @Test
    public void nullOrBlankTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate("  "));
        assertThatIllegalArgumentException().isThrownBy(() -> StringCalculator.calculate(null));
    }

    @DisplayName("덧셈 테스트")
    @Test
    public void plusTest() {
        assertThat(StringCalculator.calculate("1 + 2")).isEqualTo(3);
    }

    @DisplayName("뺼셈 테스트")
    @Test
    public void minusTest() {
        assertThat(StringCalculator.calculate("1 - 2")).isEqualTo(-1);
    }

    @DisplayName("곱셈 테스트")
    @Test
    public void multiplyTest() {
        assertThat(StringCalculator.calculate("5 * 2")).isEqualTo(10);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    public void divideTest() {
        assertThat(StringCalculator.calculate("10 / 3")).isEqualTo(3);
    }

}
