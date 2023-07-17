package lotto;

import lotto.domain.LottoRank;
import lotto.domain.LottoResults;
import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoResultsTest {

    @Test
    @DisplayName("당첨 결과를 바탕으로 수익률을 계산한다.")
    void profitRate() {
        LottoResults lottoResults = new LottoResults(List.of(LottoRank.FIRST, LottoRank.FIRST));
        Assertions.assertThat(lottoResults.getProfitRate().getProfitRate()).isEqualTo(2_000_000.0);
    }
}