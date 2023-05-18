package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void 매치_카운트로_랭크_조회() {
        Rank rank = Rank.findByMatchCount(6);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void 랭크_리워드_총합() {
        int reward = Rank.THIRD.totalReward(2);
        assertThat(reward).isEqualTo(100000);
    }
}
