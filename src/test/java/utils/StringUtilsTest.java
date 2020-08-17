package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.StringUtils;

import static org.assertj.core.api.Assertions.*;

public class StringUtilsTest {

    @DisplayName("isBlank - null 입력 테스트")
    @Test
    void isBlank_null_test() {
        assertThat(StringUtils.isBlank(null)).isTrue();
    }

    @DisplayName("isBlank - 빈 문자열 입력 테스트")
    @Test
    void isBlank_empty_string_test() {
        assertThat(StringUtils.isBlank(" ")).isTrue();
    }

    @DisplayName("isBlank - 여러 문자열 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-", "한글", "Englisheiscute"})
    void isBlank_not_blank_test(String input) {
        assertThat(StringUtils.isBlank(input)).isFalse();
    }

    @DisplayName("toNumber 정상적으로 변환되는 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:3", "-1:-1", "000:0"}, delimiter = ':')
    void toNumber_test(String input, int result) {
        assertThatCode(() -> StringUtils.toNumber(input))
                .isEqualTo(result)
                .doesNotThrowAnyException();
    }

    @DisplayName("toNumber 숫자로 변환할 수 없는 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3ㅋㄷ", "O", "())"})
        void toNumber_throw_exception_test(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> StringUtils.toNumber(input))
                .withMessage("숫자를 제대로 입력해주세요.");
    }
}
