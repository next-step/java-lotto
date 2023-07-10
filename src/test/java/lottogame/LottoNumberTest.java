package lottogame;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("숫자가 아니면 에러가 발생한다")
    @ValueSource(strings = {"a", "가나다"})
    @ParameterizedTest()
    void 로또_번호_검증_실패_문자(String value) {
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> new LottoNumber(value));
    }
    @DisplayName("null이면 에러가 발생한다")
    @Test()
    void 로또_번호_검증_실패_null() {
        String value = null;

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(value))
            .withMessage("숫자를 입력해야 합니다");
    }

    @DisplayName("비어있거나 공백인 경우 에러가 발생한다")
    @ValueSource(strings = {"", " ", "  "})
    @ParameterizedTest()
    void 로또_번호_검증_실패_공백(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(value))
            .withMessage("숫자를 입력해야 합니다");
    }

    @DisplayName("1이상 45이하의 숫자가 아니면 에러가 발생한다")
    @ValueSource(strings = {"0", "46"})
    @ParameterizedTest()
    void 로또_번호_검증_실패_범위(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(value))
            .withMessage("1이상 45이하의 숫자여야합니다");
    }

    @DisplayName("1이상 45이하의 숫자면 에러가 발생하지 않는다")
    @ValueSource(strings = {"1", "45", "  23   "})
    @ParameterizedTest()
    void 로또_번호_검증_성공(String value) {
        assertThatNoException()
            .isThrownBy(() -> new LottoNumber(value));
    }

}
