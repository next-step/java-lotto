package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -3, -100, 46, 77})
    @DisplayName("1 ~ 45 사이 외의 숫자로는 LottoNumber 객체를 생성할 수 없다.")
    void create_withNullOrEmpty(int value) {
        assertThatThrownBy(() -> new LottoNumber(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("1 ~ 45 외의 숫자는 허용되지 않습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null이나 빈 문자열로 LottoNumber 객체를 생성할 수 없다.")
    void create_withNullOrEmpty(String value) {
        assertThatThrownBy(() -> new LottoNumber(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 값이 누락되었습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-9", "##51"})
    @DisplayName("숫자 이외의 문자열로 LottoNumber 객체를 생성할 수 없다.")
    void create_withInvalidString(String value) {
        assertThatThrownBy(() -> new LottoNumber(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("변환할 수 없는 문자가 포함되어 있습니다.");
    }

}
