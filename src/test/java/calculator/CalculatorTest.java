package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
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
    @DisplayName("값이 비어있는 경우 IllegalArgumentException 예외가 발생한다.")
    void test03() {
        final String userInput = null;
        assertThatThrownBy(() -> Calculator.calculate(userInput))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
