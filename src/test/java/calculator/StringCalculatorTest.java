package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("splitSum_null_또는_빈문자 성공 테스트")
    void splitSum_null_또는_빈문자() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("splitAndSum_숫자하나 성공 테스트")
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("splitAndSum_쉼표구분자 성공 테스트")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("splitAndSum_쉼표_또는_콜론_구분자 성공 테스트")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndSum_custom_구분자 성공 테스트")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndSum_negative Exception 테스트")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
