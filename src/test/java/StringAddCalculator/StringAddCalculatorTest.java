package StringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @DisplayName(value = "null 또는 빈 문자열이면 예외")
    @Test
    void null_or_empty() {
        assertThatThrownBy(() -> StringAddCalculator.sum(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> StringAddCalculator.sum(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "숫자 하나일 경우 그대로 반환")
    @Test
    void 숫자_하나() {
        int result = StringAddCalculator.sum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName(value = "쉼표 구분자로 문자열을 더한다.")
    @Test
    void 쉼표_구분자() {
        int result = StringAddCalculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName(value = "쉼표, 콜론를 구분자로 문자열을 더한다.")
    @Test
    void 쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.sum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName(value = "커스텀 구분자로 문자열을 더한다.")
    @Test
    void 커스텀_구분자() {
        int result = StringAddCalculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName(value = "음수를 전달할 경우 RuntimeException")
    @Test
    void 음수일_경우_예외() {
        assertThatThrownBy(() -> StringAddCalculator.sum("1,-2:3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName(value = "숫자가 아닐경우 경우 NumberFormatException")
    @Test
    void 숫자가_아닐_경우_예외() {
        assertThatThrownBy(() -> StringAddCalculator.sum("1,d:3"))
                .isInstanceOf(NumberFormatException.class);
    }
}
