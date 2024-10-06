package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    @DisplayName("입력값이 비어있는 경우 IllegalArgumentException 예외가 발생한다.")
    void test03() {
        final String userInput = null;

        assertThatThrownBy(() -> Calculator.calculate(userInput))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 숫자 하나일 경우 해당 숫자를 그대로 반환한다.")
    void test01() {
        final String userInput = "3";

        assertThat(Calculator.calculate(userInput)).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자, 공백, 부호(+, -, *, /) 외 문자가 입력된 경우 IllegalArgumentException 예외가 발생한다.")
    void test02() {
        final String userInput = "1 _ 3";

        assertThatThrownBy(() -> Calculator.calculate(userInput))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("홀수번째 배열에 사칙연산 부호가 없는 경우 IllegalArgumentException 예외가 발생한다.")
    void test04() {
        final String userInput = "5 3";

        assertThatThrownBy(() -> Calculator.calculate(userInput))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("짝수번째 배열에 숫자가 존재하지 않는 경우 IllegalArgumentException 예외가 발생한다.")
    void test05() {
        final String userInput = "3 + + 2";

        assertThatThrownBy(() -> Calculator.calculate(userInput))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("배열의 크기가 짝수라면 IllegalArgumentException 예외가 발생한다.")
    void test06() {
        final String userInput = "1 + 2 / 3 +";

        assertThatThrownBy(() -> Calculator.calculate(userInput))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("8 + 5 는 13 을 반환한다.")
    void test07() {
        final String userInput = "8 + 5";

        assertThat(Calculator.calculate(userInput)).isEqualTo(13);
    }

    @Test
    @DisplayName("8 + 5 + 7 는 20 을 반환한다.")
    void test08() {
        final String userInput = "8 + 5 + 7";

        assertThat(Calculator.calculate(userInput)).isEqualTo(20);
    }
}
