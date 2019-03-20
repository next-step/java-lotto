package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void 최종_일치결과_확인() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addMatchCount(5);
        lottoResult.addMatchCount(5);
        lottoResult.addMatchCount(3);

        int[] result = lottoResult.checkResult();

        assertThat(result[5]).isEqualTo(2);
        assertThat(result[3]).isEqualTo(1);
        assertThat(result[4]).isEqualTo(0);
    }

    @Test
    public void 소수점_수익률_구하기() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addMatchCount(3);

        double rate = lottoResult.calculateRate(400000);

        assertThat(rate).isEqualTo(0.0125);
    }

    @Test
    public void 수익률_구하기() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addMatchCount(5);
        lottoResult.addMatchCount(5);
        double rate = lottoResult.calculateRate(4000);

        assertThat(rate).isEqualTo(750);
    }
}
