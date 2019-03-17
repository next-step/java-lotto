package lotto.domain;

import lotto.enums.LottoRank;
import lotto.vo.LottoResult;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProfitCalculatorTest {
    @Test
    public void 총_당첨금액_계산() {
        // given
        long[] matchCounts = new long[Lotto.TOTAL_LOTTO_NUMBERS + 1];
        matchCounts[LottoRank.FIRST.getMatchCount()]++;
        matchCounts[LottoRank.THIRD.getMatchCount()]++;

        LottoResult lottoResult = new LottoResult(matchCounts);

        // when
        long totalPrize = LottoProfitCalculator.getTotalPrizeMoney(lottoResult);

        // then
        assertThat(totalPrize)
                .isEqualTo(LottoRank.FIRST.getPrizeMoney() + LottoRank.THIRD.getPrizeMoney());
    }

    @Test
    public void 총_수익률_계산() {
        // given
        long[] matchCounts = new long[Lotto.TOTAL_LOTTO_NUMBERS + 1];
        matchCounts[LottoRank.FIRST.getMatchCount()]++;
        matchCounts[LottoRank.THIRD.getMatchCount()]++;

        LottoResult lottoResult = new LottoResult(matchCounts);
        long cost = 5_000;

        // when
        double totalProfitRate = LottoProfitCalculator.getTotalProfitRate(cost, lottoResult);

        // then
        assertThat(totalProfitRate)
                .isEqualTo((LottoRank.FIRST.getPrizeMoney() + LottoRank.THIRD.getPrizeMoney()) / cost);
    }
}
