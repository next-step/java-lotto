package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 로또_당첨_금액_확인() {
        LottoResult lottoResult = new LottoResult();

        lottoResult.matchCounting(6, false);

        assertThat(lottoResult.getWinProfit()).isEqualTo(2000000000);
    }
}
