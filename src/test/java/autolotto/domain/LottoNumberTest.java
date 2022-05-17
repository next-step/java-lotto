package autolotto.domain;

import autolotto.exception.LottoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static autolotto.exception.LottoExceptionCode.INVALID_LOTTO_NUMBER_TYPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void numberIsNotLottoFormatGiven_ThrowException(String number) {
        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_TYPE.getMessage());
    }

    @Test
    void sameNumberGiven_ReturnSameInstance() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        LottoNumber lottoNumber2 = LottoNumber.of(1);
        assertThat(lottoNumber == lottoNumber2).isTrue();
    }
}
