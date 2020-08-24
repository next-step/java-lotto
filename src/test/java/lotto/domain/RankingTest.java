package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @DisplayName("count 입력 결과 enum value 테스트")
    @Test
    void findRankingByCountTest() {
        assertThat(Ranking.valueOfRanking(6, false)).isEqualTo(Ranking.FIRST);
    }

    @DisplayName("당첨 통계 enum value 테스트")
    @Test
    void findStatisticsTest() {
        assertThat(Ranking.findStatistics()).doesNotContain(Ranking.MISS);
    }
}