package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException을 던진다")
    void filterValidInput_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("");
                }).withMessageMatching("널 또는 공백 입력");
    }

    @Test
    @DisplayName("입력 값이 연산자가 아닐 경우 IllegalArgumentException을 던진다")
    void filterValidOperations_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("1 + 2 ? 3");
                }).withMessageMatching("연산자 아닙니다.");
    }

    @Test
    @DisplayName("유효하지 않은 수식일 경우 IllegalArgumentException을 던진다")
    void checkValidExpressions_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("1 + 2 -");
                }).withMessageMatching("유효하지 않은 수식입니다.");
    }


    @Test
    void 덧셈_연산_테스트() {
        int actual = calculator.calculate("1 + 3");
        assertThat(actual).isEqualTo(4);
    }

    @Test
    void 뺄셈_연산_테스트() {
        int actual = calculator.calculate("3 - 2");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void 나누셈_연산_테스트() {
        int actual = calculator.calculate("10 / 2");
        assertThat(actual).isEqualTo(5);
    }

    @Test
    void 곱셈_연산_테스트() {
        int actual = calculator.calculate("10 * 2");
        assertThat(actual).isEqualTo(20);
    }

    @Test
    void 여러_수식_연산_테스트() {
        int actual = calculator.calculate("10 / 2 - 3 * 2");
        assertThat(actual).isEqualTo(4);
    }

}