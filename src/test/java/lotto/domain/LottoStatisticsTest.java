package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoStatisticsTest {
    @Test
    void 당첨_통계_생성() {
        // given
        List<LottoRank> lottoRanks = List.of(LottoRank.SECOND, LottoRank.THIRD);

        // when
        LottoStatistics statistics = LottoStatistics.create(lottoRanks);

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
        List<LottoRank> lottoRanks = List.of(LottoRank.FOURTH, LottoRank.FIFTH);
        LottoStatistics lottoStatistics = LottoStatistics.create(lottoRanks);

        // when
        int totalProfit = lottoStatistics.calculateTotalProfit();

        // then
        Assertions.assertThat(totalProfit).isEqualTo(55000);
    }

    @Test
    void 수익률_계산() {
        // given
        int totalPurchaseAmount = 30000;
        List<LottoRank> lottoRanks = List.of(LottoRank.FOURTH, LottoRank.FIFTH);
        LottoStatistics lottoStatistics = LottoStatistics.create(lottoRanks);

        // when
        float profitRate = lottoStatistics.calculateProfitRate(totalPurchaseAmount);

        // then
        Assertions.assertThat(profitRate).isEqualTo(1.83f);
    }
}
