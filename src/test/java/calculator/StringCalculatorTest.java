package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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
}
