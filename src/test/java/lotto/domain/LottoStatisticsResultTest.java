package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsResultTest {

    @DisplayName("로또 당첨 결과 리스트로 통계 결과를 생성해야 한다.")
    @Test
    void create_givenRankList() {
        List<LottoRank> ranks = List.of(LottoRank.FIRST, LottoRank.SECOND, LottoRank.FOURTH, LottoRank.NONE, LottoRank.FIRST);
        LottoStatisticsResult actual = LottoStatisticsResult.from(ranks);
        assertThat(actual).isEqualTo(new LottoStatisticsResult(
                Map.ofEntries(
                        Map.entry(LottoRank.FIRST, 2),
                        Map.entry(LottoRank.SECOND, 1),
                        Map.entry(LottoRank.FOURTH, 1),
                        Map.entry(LottoRank.NONE, 1)
                )
        ));

        double expectedProfit = (2_000_000_000L * 2 + 1_500_000 + 5_000) / (5 * 1_000) * 100.0;
        assertThat(actual.getProfit()).isEqualTo(expectedProfit);
    }

}
