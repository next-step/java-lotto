package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CalculatorTest {
    final String values = "2 + 3 * 4 / 2 - 1";
    final int result = 9;

    @Test
    @DisplayName("입력값을 공백에 따라 나눈다.")
    void split() {
        final String[] targetArray = values.split(" ");

        assertThat(targetArray)
                .hasSize(9);
    }

    @Test
    @DisplayName("음수를 받았을경우 정수로 치환하는 기능 학습테스트")
    void test() {
        assertThat(Integer.parseInt("-1"))
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("입력값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 을 throw 한다.")
    void nullOrBlank() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> {
                    Calculator.calculate(null);
                }),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> {
                    Calculator.calculate("");
                }),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> {
                    Calculator.calculate(" ");
                })
        );
    }

    @Test
    @DisplayName("숫자가 아닌 값이 사칙연산 기호가 아닐경우 IllegalArgumentException 을 throw 한다.")
    void checkFourArithmeticSymbols() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator.calculate("1 $ 2");
        });
    }

    @Test
    @DisplayName("덧셈")
    void plus() {
        final String values = "1 + 4";

        assertThat(Calculator.calculate(values))
                .isEqualTo(5);
    }

    @ParameterizedTest(name = "뺄셈")
    @CsvSource(value = {"2 - 3,-1", "4 - 2,2"})
    void minus(String values, int result) {
        assertThat(Calculator.calculate(values))
                .isEqualTo(result);
    }

    @ParameterizedTest(name = "곱셈")
    @CsvSource(value = {"2 * -3,-6", "4 * -2,-8"})
    void multiplication(String values, int result) {
        assertThat(Calculator.calculate(values))
                .isEqualTo(result);
    }

    @ParameterizedTest(name = "나눗셈")
    @CsvSource(value = {"4 / -2,-2", "6 / 2,3"})
    void division(String values, int result) {
        assertThat(Calculator.calculate(values))
                .isEqualTo(result);
    }

    @Test
    @DisplayName("계산기 테스트")
    void calculate() {
        assertThat(Calculator.calculate(values))
                .isEqualTo(result);
    }
}
