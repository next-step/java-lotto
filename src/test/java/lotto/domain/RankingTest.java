package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @DisplayName("ranking value map 테스트")
    @Test
    void valueMapTest() {
        assertThat(Ranking.valueMap().size()).isNotZero();
        assertThat(Ranking.valueMap().get(Ranking.FOURTH)).isZero();
    }

    @DisplayName("count 입력 결과 enum value 테스트")
    @Test
    void findRankingByCountTest() {
        assertThat(Ranking.valueOfRanking(6)).isEqualTo(Ranking.FIRST);
    }
}