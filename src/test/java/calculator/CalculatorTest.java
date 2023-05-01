package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    @DisplayName("덧셈 테스트")
    public void additionTest() {
        String input = "2 + 3";
        Integer actual = Calculator.calculate(input);
        assertThat(actual).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    public void subtractTest() {
        String input = "10 - 3";
        Integer actual = Calculator.calculate(input);
        assertThat(actual).isEqualTo(7);
    }

    @Test
    @DisplayName("곱셈 테스트")
    public void multiplicationTest() {
        String input = "4 * 3";
        Integer actual = Calculator.calculate(input);
        assertThat(actual).isEqualTo(12);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    public void divisionTest() {
        String input = "6 / 3";
        Integer actual = Calculator.calculate(input);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("빈 문자열 입력 테스트")
    public void emptyStringTest() {
        String input = "";
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없습니다.");
    }
}
