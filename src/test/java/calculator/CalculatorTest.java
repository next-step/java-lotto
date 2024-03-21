package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("정상 문자열 입력 테스트")
    void test01() {

        String input = "2 + 3 * 4 / 2";
        assertThat(Calculator.calculate(input)).isEqualTo(10);
    }

    @Test
    @DisplayName("0으로 나누는 경우 예외 발생")
    void test02() {

        String input = "2 + 3 * 4 / 0";

        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 예외 발생")
    void test03() {

        String input = " ";

        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈값이 입력되었습니다.");
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 예외 발생")
    void test04() {

        String input = "1 * 2 @ 3 / 4";

        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 형식에 맞지 않습니다.");
    }

    @DisplayName("사칙연산 테스트")
    @ParameterizedTest
    @CsvSource({"1 + 2,3", "2 - 1,1", "1 * 3,3", "4 / 2,2"})
    void test05(String input, int result) {

        int value = Calculator.calculate(input);

        assertThat(result).isEqualTo(value);
    }
}