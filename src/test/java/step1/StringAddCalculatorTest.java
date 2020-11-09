package step1;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringAddCalculatorTest {
    @DisplayName("문자열이 null인 경우")
    @Test
    public void splitAndSum_null() {
        final int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("문자열이 blank인 경우")
    @Test
    public void splitAndSum_blank() {
        final int result = StringAddCalculator.splitAndSum("");
        AssertionsForClassTypes.assertThat(result).isEqualTo(0);
    }

    @DisplayName("문자열에 숫자가 하나인 경우")
    @Test
    public void splitAndSum_one_number() {
        final int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자")
    @Test
    public void splitAndSum_comma_delimiter() {
        final int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("콜론 구분자")
    @Test
    public void splitAndSum_colon_delimiter() {
        final int result = StringAddCalculator.splitAndSum("1:2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("쉼표, 콜론 구분자")
    @Test
    public void splitAndSum_comma_and_colon_delimiter() {
        final int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자")
    @Test
    public void splitAndSum_custom_delimiter() {
        final int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("문자열에 음수 존재")
    @Test
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("문자열에 숫자가 아닌 문자 존재")
    @Test
    public void splitAndSum_not_number() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("홍,성,민"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("구현중");
    }
}
