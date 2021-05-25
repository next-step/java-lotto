package lotto.domain;

import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.common.ErrorCode;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호 범위 테스트")
    @ValueSource(ints = {0, 46})
    void lottoNumber_throwInvalidLottoNumberRange(int lottoNumber) {
        assertThatThrownBy(()->new LottoNumber(lottoNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
    }
}
