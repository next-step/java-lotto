package lotto.domain;

import static lotto.config.LottoExceptionMessage.LOTTO_NUMBER_MUST_BE_IN_VALID_RANGE;
import static lotto.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER})
    @DisplayName("로또에 사용되는 번호를 생성한다.")
    void LottoNumber_ValidNumber(final int validNumber) {
        assertThat(LottoNumber.from(validNumber))
                .isEqualTo(new LottoNumber(validNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {MINIMUM_LOTTO_NUMBER - 1, MAXIMUM_LOTTO_NUMBER + 1})
    @DisplayName("로또 번호가 최소, 최대 범위를 벗어나는 경우 예외를 던진다.")
    void LottoNumber_OutOfRange_Exception(final int numberOutOfRange) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.from(numberOutOfRange))
                .withMessage(LOTTO_NUMBER_MUST_BE_IN_VALID_RANGE.message(numberOutOfRange));
    }
}
