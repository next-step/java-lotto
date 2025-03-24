package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsTest {
    @Test
    void 숫자_매칭_갯수_테스트() {
        Rewards rewards = new Rewards(List.of(
                new Reward(3),
                new Reward(3),
                new Reward(4),
                new Reward(5)
        ));
        assertThat(rewards.getMatchCounts()).isEqualTo(Map.of(3, 2, 4, 1, 5, 1));
    }

    @Test
    void 수익률_테스트() {
        Rewards rewards = new Rewards(List.of(
                new Reward(3),
                new Reward(3),
                new Reward(4),
                new Reward(5)
        ));
        assertThat(rewards.getRateOfReturn(1000)).isEqualTo(1560);
    }
}