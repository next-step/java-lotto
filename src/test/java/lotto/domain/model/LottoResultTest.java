package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("로또 결과 추가 시 랭크별 카운트가 증가한다.")
    void shouldIncrementRankCountsCorrectly() {
        LottoResult lottoResult = new LottoResult();

        lottoResult.addResult(Rank.FIRST);
        lottoResult.addResult(Rank.FIRST);
        lottoResult.addResult(Rank.SECOND);

        Map<Rank, Integer> rankCounts = lottoResult.getRankCounts();
        assertThat(rankCounts.get(Rank.FIRST)).isEqualTo(2);
        assertThat(rankCounts.get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 결과로 총 상금을 계산할 수 있다.")
    void shouldCalculateTotalPrizeCorrectly() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addResult(Rank.FIRST);
        lottoResult.addResult(Rank.SECOND);
        lottoResult.addResult(Rank.THIRD);

        int totalPrize = lottoResult.getTotalPrize();

        int expectedTotalPrize =
                Rank.FIRST.getWinningPrize() + Rank.SECOND.getWinningPrize() + Rank.THIRD.getWinningPrize();
        assertThat(totalPrize).isEqualTo(expectedTotalPrize);
    }

    @Test
    @DisplayName("로또 결과로 수익률을 계산할 수 있다.")
    void shouldCalculateYieldCorrectly() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addResult(Rank.FIRST);
        int purchaseAmount = 10000;

        double yield = lottoResult.calculateYield(purchaseAmount);

        double expectedYield = (double) Rank.FIRST.getWinningPrize() / purchaseAmount;
        assertThat(yield).isEqualTo(expectedYield);
    }
}
