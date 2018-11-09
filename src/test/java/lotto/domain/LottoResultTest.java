package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LottoResultTest {

    @Test
    public void  당첨금_검증() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addResult(LottoMachine.getPrize(3));  // 5000
        lottoResult.addResult(LottoMachine.getPrize(3));  // 5000
        lottoResult.addResult(LottoMachine.getPrize(4));  // 50000
        lottoResult.addResult(LottoMachine.getPrize(5));  // 1500000

        assertThat(lottoResult.getCountByMatchCount(3)).isEqualTo(2);
        assertThat(lottoResult.getCountByMatchCount(4)).isEqualTo(1);
        assertThat(lottoResult.getCountByMatchCount(5)).isEqualTo(1);
        assertThat(lottoResult.getRatePercent()).isEqualTo((1500000 + 50000 + 5000 + 5000) / 4000);
    }

}