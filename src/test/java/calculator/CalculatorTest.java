package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    @DisplayName("숫자 하나만 문자열로 입력할 경우 해당 숫자를 반환한다")
    void shouldReturnIfSingleInput() {
        int result = Calculator.calculate("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 여러 개를 입력할 경우 쉼표를 구분자로 분리한다")
    void shouldSplitByComma() {
        int result = Calculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 입력할 경우 이를 기준으로 숫자를 분리한다")
    void shouldSplitByCustomDelimiter() {
        int result = Calculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달하면 예외를 던진다")
    void shouldThrowIfNegative() {
        assertThatThrownBy(() -> Calculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 값을 전달하면 예외를 던진다")
    void shouldThrowIfNotNumber() {
        assertThatThrownBy(() -> Calculator.calculate("1,%,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자가 아닌 값은 입력할 수 없습니다.");
    }

}