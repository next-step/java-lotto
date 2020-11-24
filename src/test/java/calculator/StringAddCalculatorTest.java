package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("null과 빈 문자열을 입력시 0을 반환")
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.add(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("하나의 숫자를 입력하면 그 숫자를 반환")
    public void splitAndSum_숫자하나() {
        int result = StringAddCalculator.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표로 구분하여 숫자들을 스플릿 후 합산")
    public void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.add("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론으로 구분하여 숫자들을 스플릿 후 합산")
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Custom 구분자로 구분하여 숫자들을 스플릿 후 합산")
    public void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력시 Runtime Exception 발생")
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.add("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
