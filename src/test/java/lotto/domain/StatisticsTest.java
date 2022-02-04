package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    private final List<LottoRank> givenRanks = new ArrayList<LottoRank>() {
        {
            add(LottoRank.FIRST);
            add(LottoRank.FAIL);
            add(LottoRank.THIRD);
            add(LottoRank.SECOND);
            add(LottoRank.SECOND);
        }
    };
    private final LottoRanks lottoRanks = new LottoRanks(givenRanks);

    @DisplayName("생성 확인.")
    @Test
    void 생성자() {
        // then
        Assertions.assertDoesNotThrow(() -> new Statistics(lottoRanks));
    }

    @DisplayName("등수별 당첨 수 구하기.")
    @Test
    void getRankCount() {
        // given
        Statistics statistics = new Statistics(lottoRanks);

        // when
        Map<LottoRank, Integer> rankCounts = statistics.getRankCounts().get();

        // then
        assertThat(rankCounts.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.SECOND)).isEqualTo(2);
        assertThat(rankCounts.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(rankCounts.get(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(rankCounts.get(LottoRank.FIFTH)).isEqualTo(0);
    }

    @DisplayName("총 수익률 구하기.")
    @Test
    void getProfitRate() {
        // given
        Statistics statistics = new Statistics(lottoRanks);

        double rate = statistics.getProfitRate();
        double expected = (LottoRank.FIRST.getAmount() + LottoRank.SECOND.getAmount() * 2 + LottoRank.THIRD.getAmount()) / givenRanks.size();

        assertThat(rate).isEqualTo(expected);
    }
}
