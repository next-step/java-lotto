package lotto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSummaryTest {

    @Test
    public void 수익률_계산() {
        LottoResult forthRank = new LottoResult(3);

        LottoSummary summary = new LottoSummary(List.of(forthRank), new Money(14000));

        assertThat(summary.getForthRankCount()).isEqualTo(1);
        assertThat(summary.getRateOfReturn()).isEqualTo(new BigDecimal("0.35"));
    }


}