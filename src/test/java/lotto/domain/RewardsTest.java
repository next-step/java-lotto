package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class RewardsTest {
    @Test
    @DisplayName("보상이 없는 객체 생성 불가")
    void create() {
        Assertions.assertThatThrownBy(() -> new Rewards(Map.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1등이 1개 있으면 1리턴")
    void firstPrizeCount() {
        Rewards rewards = new Rewards(Map.of(Reward.FIRST, 1,
                Reward.SECOND, 2,
                Reward.THIRD, 1,
                Reward.FOURTH, 1
        ));
        Assertions.assertThat(rewards.prizeCount(Reward.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등이 2개 있으면 2리턴")
    void secondPrizeCount() {
        Rewards rewards = new Rewards(Map.of(Reward.FIRST, 1,
                Reward.SECOND, 2,
                Reward.THIRD, 1,
                Reward.FOURTH, 1
        ));
        Assertions.assertThat(rewards.prizeCount(Reward.SECOND)).isEqualTo(2);
    }

    @Test
    @DisplayName("3등이 1개 있으면 1리턴")
    void thirdPrizeCount() {
        Rewards rewards = new Rewards(Map.of(Reward.FIRST, 1,
                Reward.SECOND, 2,
                Reward.THIRD, 1,
                Reward.FOURTH, 1
        ));
        Assertions.assertThat(rewards.prizeCount(Reward.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("4등이 1개 있으면 1리턴")
    void fourthPrizeCount() {
        Rewards rewards = new Rewards(Map.of(Reward.FIRST, 1,
                Reward.SECOND, 2,
                Reward.THIRD, 1,
                Reward.FOURTH, 1
        ));
        Assertions.assertThat(rewards.prizeCount(Reward.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("5등이 1개 있으면 1리턴")
    void fifthPrizeCount() {
        Rewards rewards = new Rewards(Map.of(Reward.FIRST, 1,
                Reward.SECOND, 2,
                Reward.THIRD, 1,
                Reward.FOURTH, 1,
                Reward.FIFTH, 1
        ));
        Assertions.assertThat(rewards.prizeCount(Reward.FOURTH)).isEqualTo(1);
    }
}
