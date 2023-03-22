package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoNumberTest {

    @Test
    void 당첨_번호와_보너스번호_중복이_불가하다() {

        Set<LottoNumber> lottoNumber = new HashSet<>();
        for(int i : Arrays.asList(1, 3, 5, 7, 9, 11))
        {
            lottoNumber.add(new LottoNumber(i));
        }
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinLottoNumber(new LottoNumbers(lottoNumber), new LottoNumber(5)));
    }
}