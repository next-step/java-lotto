package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    @Test
    void 생성() {
        LottoResult lottoResult = new LottoResult("1,2,3,4,5,6");
        assertThat(lottoResult).isEqualTo(new LottoResult("1,2,3,4,5,6"));
    }

    @Test
    void 로또_상금_구하기_테스트() {
        LottoResult lottoResult = new LottoResult("1,2,3,4,5,6");
        assertThat(lottoResult.getWinningLottoAmount(Arrays.asList(Lotto.of(1,2,3,4,5,6), Lotto.of(13,11,12,15,16,17)))).contains(WinningLottoAmount.FIRST);
    }

    @Test
    void 수익률_계산() {
        LottoResult lottoResult = new LottoResult("1,2,3,4,5,6");
        double result = lottoResult.rateOfReturn(Arrays.asList(Lotto.of(1,2,3,7,8,9), Lotto.of(13,11,12,15,16,17)));
        assertThat(result).isEqualTo(2.5);
    }
}