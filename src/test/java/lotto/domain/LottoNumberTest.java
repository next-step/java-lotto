package lotto.domain;

import static lotto.domain.LottoNumber.LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("로또 숫자가 1에서 45 사이인지 검증한다.")
    @ValueSource(ints = {0, 46})
    void validate_lotto_number(int given) {
        // when // then
        assertThatThrownBy(() -> new LottoNumber(given))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION);
    }
}
