import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @DisplayName("입력 값이 null 또는 공백인 경우 예외 발생")
    @Test
    void test01() {
        // given
        String input = "";

        // when / then
        Assertions.assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값은 null이거나 공백일 수 없습니다.");
    }
}
