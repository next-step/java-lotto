package lotto.domain;

import static lotto.exception.ExceptionMessage.ERROR_EMPTY_VALUE;
import static lotto.exception.ExceptionMessage.ERROR_INVALID_VALUE_TO_CONVERT;
import static lotto.exception.ExceptionMessage.ERROR_OUT_OF_LOTTO_NUMBER_BOUND;
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
            .hasMessage(ERROR_OUT_OF_LOTTO_NUMBER_BOUND.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null이나 빈 문자열로 LottoNumber 객체를 생성할 수 없다.")
    void create_withNullOrEmpty(String value) {
        assertThatThrownBy(() -> LottoNumber.from(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_EMPTY_VALUE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-9", "##51"})
    @DisplayName("숫자 이외의 문자열로 LottoNumber 객체를 생성할 수 없다.")
    void create_withInvalidString(String value) {
        assertThatThrownBy(() -> LottoNumber.from(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_INVALID_VALUE_TO_CONVERT.getMessage());
    }
}
