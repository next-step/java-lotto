package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankRewardTest {
    private RankReward rankReward;

    @BeforeEach
    void setUp() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);
        ranks.add(Rank.FIFTH);
        rankReward = new RankReward(ranks);
    }

    @Test
    void getGainRanksCounts_5등1개카운트() {
        assertThat(rankReward.getGainRanksCounts().get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    void getRewardWinningMoney_5등금액() {
        assertThat(rankReward.getRewardWinningMoney()).isEqualTo(Rank.FIFTH.getWinningMoney());
    }
}
