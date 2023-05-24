package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    void 매치카운트_보너스번호매칭여부로_랭크_조회() {
        Rank rank = Rank.find(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
        rank = Rank.find(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    void 랭크_리워드_총합() {
        int reward = Rank.THIRD.totalReward(2);
        assertThat(reward).isEqualTo(Rank.THIRD.reward() * 2);
    }
}
