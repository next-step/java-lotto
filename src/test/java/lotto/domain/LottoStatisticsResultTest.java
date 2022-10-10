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
        List<LottoRank> ranks = List.of(LottoRank.NONE, LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.FIFTH, LottoRank.NONE, LottoRank.NONE);
        LottoStatisticsResult actual = LottoStatisticsResult.from(ranks);
        assertThat(actual).isEqualTo(new LottoStatisticsResult(
                Map.ofEntries(
                        Map.entry(LottoRank.FOURTH, 1),
                        Map.entry(LottoRank.FIFTH, 2),
                        Map.entry(LottoRank.NONE, 3)
                )
        ));
        assertThat(actual.getProfit()).isEqualTo(10);
    }

}
