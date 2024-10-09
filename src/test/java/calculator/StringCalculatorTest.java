package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("덧셈이 정확하게 작동하는지 확인")
    @ValueSource(strings = {"3 + 5 + 7"})
    void addTest(String input) {
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculator(input)).isEqualTo(15);
    }

    @ParameterizedTest
    @DisplayName("뺄셈이 정확하게 작동하는지 확인")
    @ValueSource(strings = {"10 - 5 - 2"})
    void minusTest(String input) {
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculator(input)).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("곱셈이 정확하게 작동하는지 확인")
    @ValueSource(strings = {"10 * 5 * 2"})
    void multipleTest(String input) {
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculator(input)).isEqualTo(100);
    }

    @ParameterizedTest
    @DisplayName("나눗셈이 정확하게 작동하는지 확인")
    @ValueSource(strings = {"100 / 5 / 2"})
    void divisionTest(String input) {
        StringCalculator calculator = new StringCalculator();
        assertThat(calculator.calculator(input)).isEqualTo(10);
    }

    @ParameterizedTest
    @DisplayName("빈 공백 문자일 경우 IllegalArgumentException 나오는지 확인")
    @ValueSource(strings = {""})
    void validationBlinkTest(String input) {
        StringCalculator calculator = new StringCalculator();
        assertThatThrownBy(() -> calculator.calculator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값이 null일 경우 IllegalArgumentException 나오는지 확인")
    void validationNullTest() {
        StringCalculator calculator = new StringCalculator();
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculator(null));
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 나오는지 확인")
    @ValueSource(strings = {"5 ! 6"})
    void validationOperatorTest(String input) {
        StringCalculator calculator = new StringCalculator();
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculator(input));
    }
}
