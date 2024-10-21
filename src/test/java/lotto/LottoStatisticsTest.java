package lotto;

import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoStatisticsTest {
    @Test
    void 당첨_통계_생성() {
        // given
        List<Integer> equalNumberCountList = List.of(3, 4);

        // when
        LottoStatistics statistics = LottoStatistics.create(equalNumberCountList);

        // then
        Assertions.assertThat(statistics.getCount(LottoRank.FIRST)).isEqualTo(0);
        Assertions.assertThat(statistics.getCount(LottoRank.SECOND)).isEqualTo(0);
        Assertions.assertThat(statistics.getCount(LottoRank.THIRD)).isEqualTo(1);
        Assertions.assertThat(statistics.getCount(LottoRank.FOURTH)).isEqualTo(1);
    }

    @Test
    void 수익_금액_계산() {
        // given
        List<Integer> winningNumberCountList = List.of(3, 4);
        LottoStatistics lottoStatistics = LottoStatistics.create(winningNumberCountList);

        // when
        int totalProfit = lottoStatistics.calculateTotalProfit();

        // then
        Assertions.assertThat(totalProfit).isEqualTo(55000);
    }

    @Test
    void 수익률_계산() {
        // given
        int totalPurchaseAmount = 30000;
        List<Integer> winningNumberCountList = List.of(3, 4);
        LottoStatistics lottoStatistics = LottoStatistics.create(winningNumberCountList);

        // when
        float profitRate = lottoStatistics.calculateProfitRate(totalPurchaseAmount);

        // then
        Assertions.assertThat(profitRate).isEqualTo(1.83f);
    }
}
