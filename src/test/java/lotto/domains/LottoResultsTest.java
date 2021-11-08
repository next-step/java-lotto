package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultsTest {

    @Test
    void 당첨로또개수_3개미만_일치() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.addWinner(2);

        assertThat(lottoResults).isEqualTo(new LottoResults());
    }

    @Test
    void 당첨로또개수_3개이상_일치() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.addWinner(3);

        assertThat(lottoResults).isNotEqualTo(new LottoResults());
    }
}