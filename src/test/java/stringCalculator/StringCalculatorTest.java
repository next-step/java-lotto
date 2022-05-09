package stringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("빈 공백 문자열이나 null값이 들어올 경우 발생하는 예외 테스트")
    void nullOrBlankTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.putNullOrBlank(input);
        }).withMessage("빈 문자열과 null값은 입력받을 수 없습니다.");
    }

    @Test
    @DisplayName("사칙연산 기호가 아닐 경우 발생하는 예외 테스트")
    void noOperator() {
        assertThatIllegalArgumentException().isThrownBy(()-> {
            StringCalculator.classify(2, ")", 4);
        }).withMessage("사칙연산 기호만 입력받을 수 있습니다.");
    }

    @Test
    @DisplayName("덧셈 테스트")
    void plusTest() {
        assertThat(Integer.parseInt(StringCalculator.classify(4, "+", 5))).isEqualTo(9);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void minusTest() {
        assertThat(Integer.parseInt(StringCalculator.classify(5, "-", 4))).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void multiplyTest() {
        assertThat(Integer.parseInt(StringCalculator.classify(3, "*", 4))).isEqualTo(12);
    }

}
