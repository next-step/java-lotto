package stringcalculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringUtilTest {

    @DisplayName("String 값이 빈 문자열이나 null 인 경우 return true")
    @ParameterizedTest
    @NullAndEmptySource
    void isEmpty(final String value) {
        assertThat(StringUtil.isEmpty(value)).isTrue();
    }

    @DisplayName("Integer 로 변환할 수 없는 값인 경우 NumberFormatException 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = { "a", "0.4", "가" })
    void toInt(final String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> StringUtil.toInt(value));
    }
}
