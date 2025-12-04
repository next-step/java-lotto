package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("null 입력은 IllegalArgumentException을 던진다")
    void nullInput() {
        assertThatThrownBy(() -> calculator.calculate(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("공백 입력은 IllegalArgumentException을 던진다")
    void blankInput() {
        assertThatThrownBy(() -> calculator.calculate("   "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 하나만 있으면 그 값을 그대로 반환한다")
    void singleNumber() {
        int result = calculator.calculate("3");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("덧셈을 수행한다")
    void plus() {
        int result = calculator.calculate("2 + 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈을 수행한다")
    void minus() {
        int result = calculator.calculate("5 - 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈을 수행한다")
    void multiply() {
        int result = calculator.calculate("2 * 4");
        assertThat(result).isEqualTo(8);
    }

    @Test
    @DisplayName("나눗셈을 수행한다 (정수 나눗셈)")
    void divide() {
        int result = calculator.calculate("8 / 4");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("여러 연산은 왼쪽에서 오른쪽 순서대로 계산한다")
    void multipleOperationsLeftToRight() {
        int result = calculator.calculate("2 + 3 * 4 / 2");
        // (((2 + 3) * 4) / 2) = 10
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException을 던진다")
    void invalidOperator() {
        assertThatThrownBy(() -> calculator.calculate("2 & 3"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 토큰 개수(짝수 개)는 IllegalArgumentException을 던진다")
    void invalidTokenCount() {
        assertThatThrownBy(() -> calculator.calculate("2 +"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
