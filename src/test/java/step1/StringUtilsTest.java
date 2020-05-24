package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @DisplayName("빈 문자열이나 null이면 문자열 0을 반환한다")
    @NullAndEmptySource
    @ParameterizedTest
    void blankToZero_NullAndEmpty_Zero(String input) {
        String result = StringUtils.blankToZero(input);
        assertThat(result).isEqualTo("0");
    }

    @DisplayName("빈 문자열이나 null이 아니면 입력 값을 그대로 반환한다")
    @ValueSource(strings = {"1", "2", "테스트"})
    @ParameterizedTest
    void blankToZero_NotNullAndEmpty_InputValue(String input) {
        String result = StringUtils.blankToZero(input);
        assertThat(result).isEqualTo(input);
    }
}
