package lotto.domain;

import static lotto.config.LottoExceptionMessage.LOTTO_NUMBER_SHOULD_BE_IN_VALID_RANGE;
import static lotto.domain.LottoNumber.MAXIMUM;
import static lotto.domain.LottoNumber.MINIMUM;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {MINIMUM, MAXIMUM})
    @DisplayName("로또에 사용되는 번호를 생성한다.")
    void LottoNumber_ValidNumber(final int validNumber) {
        assertThat(LottoNumber.from(validNumber))
                .isEqualTo(new LottoNumber(validNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {MINIMUM - 1, MAXIMUM + 1})
    @DisplayName("로또 번호가 올바른 범위를 벗어나는 경우 예외를 던진다.")
    void LottoNumber_OutOfRange_Exception(final int numberOutOfRange) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.from(numberOutOfRange))
                .withMessage(LOTTO_NUMBER_SHOULD_BE_IN_VALID_RANGE.message(numberOutOfRange));
    }
}
