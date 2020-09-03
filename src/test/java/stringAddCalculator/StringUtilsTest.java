package stringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    @DisplayName("기본 구분자 테스트")
    void split() {
        assertThat(StringUtils.split("1,2,3")).containsExactly("1", "2", "3");
        assertThat(StringUtils.split("1:2:3")).containsExactly("1", "2", "3");
        assertThat(StringUtils.split("1,2:3")).containsExactly("1", "2", "3");
        assertThat(StringUtils.split("1,2")).containsExactly("1", "2");
        assertThat(StringUtils.split("1:2")).containsExactly("1", "2");
        assertThat(StringUtils.split("1:-2")).containsExactly("1", "-2");
    }

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void split_customDelimiter() {
        assertThat(StringUtils.split("//;\n1;2;3")).containsExactly("1", "2", "3");
        assertThat(StringUtils.split("//!\n1!2")).containsExactly("1", "2");
        assertThat(StringUtils.split("//!\n1!-2")).containsExactly("1", "-2");
        assertThat(StringUtils.split("// \n1 2")).containsExactly("1", "2");
    }

    @ParameterizedTest
    @ValueSource(strings = {"!//\n1!2", "/!/\n1!2", "//\n!1!2"})
    @DisplayName("커스텀 구분자 위치가 잘못된 경우 정상적으로 분리되지 않는다.")
    public void split_DelimiterPosition(String value) {
        assertThat(StringUtils.split(value)).doesNotContain("1", "2");
    }
}
