package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LottoResultTest {

    @Test
    public void  상금_있는_검증() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addResult(LottoPrize.FIFTH);  // 5000
        lottoResult.addResult(LottoPrize.FIFTH);  // 5000
        lottoResult.addResult(LottoPrize.FOURTH);  // 50000
        lottoResult.addResult(LottoPrize.THIRD);  // 1500000

        assertThat(lottoResult.getRatePercent()).isEqualTo((1500000 + 50000 + 5000 + 5000) / 4000);
    }

    @Test
    public void  상금_없는_검증() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addResult(LottoPrize.NONE);  // 0
        lottoResult.addResult(LottoPrize.NONE);  // 0
        lottoResult.addResult(LottoPrize.NONE);  // 0

        assertThat(lottoResult.getRatePercent()).isEqualTo(0);
    }

}