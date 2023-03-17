package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoNumberTest {

    @Test
    void 당첨_번호와_보너스번호_중복확인() {
        LottoNumbers lottoNumber = new LottoNumbers(Arrays.asList(1, 3, 5, 7, 9, 11));
        int bonusNumber = 5;
        assertThat(new WinLottoNumber(lottoNumber, bonusNumber));
    }

    @Test
    void 당첨_결과를_정상_확인() {
        LottoNumbers resultLottoNumber = new LottoNumbers(Arrays.asList(1, 3, 5, 7, 9, 11));
        LottoNumbers requestLottoNumber = new LottoNumbers(Arrays.asList(1, 3, 5, 2, 4, 6));
        int bounusNumber = 13;
        WinLottoNumber winLottoNumber = new WinLottoNumber(resultLottoNumber, bounusNumber);
        assertThat(winLottoNumber.matchingLottoNumber(requestLottoNumber)).isEqualTo(3);
    }
}