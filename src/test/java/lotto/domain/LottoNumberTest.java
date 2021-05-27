package lotto.domain;

import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.common.ErrorCode;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void createLottoNumber() {
        LottoNumber lottoNumberFromText = new LottoNumber("1");
        LottoNumber lottoNumberFromNumber = new LottoNumber(1);

        assertThat(lottoNumberFromText).isEqualTo(new LottoNumber(1));
        assertThat(lottoNumberFromNumber).isEqualTo(new LottoNumber(1));
    }

    @ParameterizedTest
    @DisplayName("로또 번호 범위 테스트")
    @ValueSource(ints = {0, 46})
    void lottoNumber_throwInvalidLottoNumberRange(int lottoNumber) {
        assertThatThrownBy(()->new LottoNumber(lottoNumber)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.INVALID_LOTTO_NUMBER_RANGE.getErrorMessage());
    }

    @Test
    @DisplayName("로또 번호 값 테스트")
    void getLottoNumber() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }
}
