package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("splitAndSum null 또는 빈 문자")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_or_empty(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("splitAndSum 숫자 하나")
    public void splitAndSum_only_one() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("splitAndSum 쉼표 구분자")
    public void splitAndSum_comma_separator() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("splitAndSum 쉼표 또는 콜론 구분자")
    public void splitAndSum_comma_or_colon_separator() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("// 와 \\n 사이로 들어오는 값을 구분자로 정해서 합계가 잘 나오는지?")
    public void splitAndSum_custom_separator() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}