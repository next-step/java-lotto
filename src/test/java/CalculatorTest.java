import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @DisplayName("입력 값이 null 또는 공백인 경우 예외 발생")
    @Test
    void test01() {
        // given
        String input = "";

        // when / then
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 null이거나 공백일 수 없습니다.");
    }

    @DisplayName("사칙연산 기호가 아닌 경우 예외 발생")
    @Test
    void test02() {
        // given
        String input = "2 + 5 | 7";

        // when / then
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사칙연산 기호가 아닙니다.");
    }

    @DisplayName("덧셈, 뺄셈, 곱셈, 나눗셈을 할 수 있다.")
    @ParameterizedTest
    @CsvSource({"2 + 3,5", "5 - 2,3", "5 * 2,10", "5 / 2,2"})
    void test03(String input, int expected) {
        // when
        int result = Calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("사칙연산을 수행할 수 있다. 이때, 연산자 우선순위는 고려하지 않고 순서대로 수행된다.")
    @Test
    void test04() {
        // given
        String input = "2 + 3 * 4 / 2";

        // when
        int result = Calculator.calculate(input);

        // then
        assertThat(result).isEqualTo(10);
    }
}
