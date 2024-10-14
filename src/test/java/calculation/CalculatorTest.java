package calculation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈")
    void addition() {
        assertThat(Calculator.addition(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    void subtraction() {
        assertThat(Calculator.subtraction(4, 3)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈")
    void multiplication() {
        assertThat(Calculator.multiplication(4, 3)).isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈")
    void division() {
        assertThat(Calculator.division(13, 4)).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:+:3", "4:3:-:1", "4:3:*:12", "13:4:/:3"}, delimiter = ':')
    @DisplayName("사칙연산 기호에 따라 다른 결과값을 출력한다.")
    void 사칙연산(int number, int number2, String symbol, int expected) {
        assertThat(Calculator.calculate(symbol, number, number2)).isEqualTo(expected);
    }

    @Test
    void 올바른_표현식() {
        assertThat(Calculator.calculateExpression("1 + 2 - 1 * 5 / 2")).isEqualTo(5);
    }

    @ParameterizedTest
    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException")
    @ValueSource(strings = {"1 a 2 + 3 * 7", "1   2", "5 % 6", "3 $ 6", "?", "#", ""})
    void 잘못된_표현식(String expression) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Calculator.calculateExpression(expression);
                }).withMessageMatching("사칙연산 기호가 아닙니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculateExpression(expression);
        });
    }

}
