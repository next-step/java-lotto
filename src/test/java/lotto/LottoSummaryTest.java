package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSummaryTest {

    @Test
    public void 수익률_계산Test() {
        LottoResult forthRank = new LottoResult(List.of(Rank.FORTH), new Money(14_000));

        LottoSummary summary = forthRank.toLottoSummary();

        assertThat(summary.getRankCount(Rank.FORTH)).isEqualTo(1);
        assertThat(summary.getRankCount(Rank.THIRD)).isEqualTo(0);
        assertThat(summary.getRankCount(Rank.SECOND)).isEqualTo(0);
        assertThat(summary.getRankCount(Rank.FIRST)).isEqualTo(0);
        assertThat(summary.rateOfReturn()).isEqualTo(0.35f);
    }


}