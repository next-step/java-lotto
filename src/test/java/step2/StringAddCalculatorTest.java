package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.StringAddCalculator.CHARACTER_OR_NEGATIVE_NUMBER_ERROR;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("문자열 계산기에 null 또는 공백 입력")
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열 계산기에 숫자 하나를 갖고 있는 문자열 입력")
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("문자열 계산에 쉼표를 갖고 있는 문자열 입력")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 계산에 쉼표와 콜론을 갖고 있는 문자열 입력")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열 계산에 custom 구분자(;)를 갖고 있는 문자열 입력")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열 계산에 음수를 갖고 있는 문자열 입력")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class).hasMessageContaining(CHARACTER_OR_NEGATIVE_NUMBER_ERROR);
    }

    @Test
    @DisplayName("문자열 계산에 문자가 포함 되어 있는 문자열 입력")
    public void splitAndSum_character() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,이,3"))
                .isInstanceOf(RuntimeException.class).hasMessageContaining(CHARACTER_OR_NEGATIVE_NUMBER_ERROR);
    }
}