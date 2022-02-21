package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    @DisplayName(value = "구매한 금액에 따라서 수익률을 계산할 수 있다")
    @Test
    void calcLottoEarningRate() {
        List<Rank> ranks = new ArrayList<>();
        LottoStatistics lottoStatistics = new LottoStatistics(ranks);
        ranks.add(Rank.FIRST);
        assertThat(lottoStatistics.getLottoEarningRate(new LottoPrice(5000))).isEqualTo(
            "400000.00");
    }

    @DisplayName(value = "랭킹 정보를 셀 수 있다")
    @Test
    void makeRankReportTest() {
        LottoStatistics lottoStatistics = new LottoStatistics(
            Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.SECOND));
        Map<Rank, Integer> rankingReport = lottoStatistics.makeRankReport();
        assertThat(rankingReport.get(Rank.SECOND)).isEqualTo(2);
        assertThat(rankingReport.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankingReport.get(Rank.THIRD)).isEqualTo(0);
    }
}
