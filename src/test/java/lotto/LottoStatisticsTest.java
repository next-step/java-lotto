package lotto;

import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoStatistics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoStatisticsTest {
    @Test
    void 당첨_통계_생성() {
        // given
        LottoResult secondRankResult = new LottoResult(true, LottoRank.SECOND.equalNumberCount);
        LottoResult thirdRankResult = new LottoResult(false, LottoRank.THIRD.equalNumberCount);
        List<LottoResult> lottoResults = List.of(secondRankResult, thirdRankResult);

        // when
        LottoStatistics statistics = LottoStatistics.create(lottoResults);

        // then
        Assertions.assertThat(statistics.getCount(LottoRank.FIRST)).isEqualTo(0);
        Assertions.assertThat(statistics.getCount(LottoRank.SECOND)).isEqualTo(1);
        Assertions.assertThat(statistics.getCount(LottoRank.THIRD)).isEqualTo(1);
        Assertions.assertThat(statistics.getCount(LottoRank.FOURTH)).isEqualTo(0);
        Assertions.assertThat(statistics.getCount(LottoRank.FIFTH)).isEqualTo(0);
    }

    @Test
    void 수익_금액_계산() {
        // given
        LottoResult secondRankResult = new LottoResult(false, LottoRank.FOURTH.equalNumberCount);
        LottoResult thirdRankResult = new LottoResult(false, LottoRank.FIFTH.equalNumberCount);
        List<LottoResult> lottoResults = List.of(secondRankResult, thirdRankResult);
        LottoStatistics lottoStatistics = LottoStatistics.create(lottoResults);

        // when
        int totalProfit = lottoStatistics.calculateTotalProfit();

        // then
        Assertions.assertThat(totalProfit).isEqualTo(55000);
    }

    @Test
    void 수익률_계산() {
        // given
        int totalPurchaseAmount = 30000;
        LottoResult secondRankResult = new LottoResult(false, LottoRank.FOURTH.equalNumberCount);
        LottoResult thirdRankResult = new LottoResult(false, LottoRank.FIFTH.equalNumberCount);
        List<LottoResult> lottoResults = List.of(secondRankResult, thirdRankResult);
        LottoStatistics lottoStatistics = LottoStatistics.create(lottoResults);

        // when
        float profitRate = lottoStatistics.calculateProfitRate(totalPurchaseAmount);

        // then
        Assertions.assertThat(profitRate).isEqualTo(1.83f);
    }
}
