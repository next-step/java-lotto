package autolotto.domain;

import autolotto.exception.LottoException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static autolotto.exception.LottoExceptionCode.INVALID_LOTTO_NUMBER_TYPE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void numberIsNotLottoFormatGiven_ThrowException(String number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(INVALID_LOTTO_NUMBER_TYPE.getMessage());
    }
}
