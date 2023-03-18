package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoNumberTest {

    @Test
    void 당첨_번호와_보너스번호_중복이_불가하다() {
        LottoNumbers lottoNumber = new LottoNumbers(Arrays.asList(1, 3, 5, 7, 9, 11));
        LottoNumber bounusNumber = new LottoNumber(5);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinLottoNumber(lottoNumber, bounusNumber));
    }
}