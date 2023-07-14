package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankResultTest {

    @Test
    @DisplayName("Rank 에 대해 결과 테스트")
    void Rank_에_대해_결과_테스트() {
        // given
        RankResult rankResult = new RankResult();
        rankResult.plusCountOfRank(Rank.THREE);
        rankResult.plusCountOfRank(Rank.THREE);
        rankResult.plusCountOfRank(Rank.SIX);

        // when , then
        assertThat(rankResult.getCountOfRank(Rank.THREE))
                .isEqualTo(2);
        assertThat(rankResult.getCountOfRank(Rank.SIX))
                .isEqualTo(1);
        assertThat(rankResult.getCountOfRank(Rank.FIVE))
                .isEqualTo(0);
        assertThat(rankResult.getCountOfRank(Rank.FOUR))
                .isEqualTo(0);
        assertThat(rankResult.getCountOfRank(Rank.FIVE_WITH_BONUS))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("Rank 에 대해 총 상금 테스트")
    void 총_상금_테스트() {
        // given
        RankResult rankResult = new RankResult();
        rankResult.plusCountOfRank(Rank.THREE);
        rankResult.plusCountOfRank(Rank.THREE);
        rankResult.plusCountOfRank(Rank.SIX);

        // when , then
        assertThat(rankResult.getTotalRankReward())
                .isEqualTo(2_000_010_000);

    }
}