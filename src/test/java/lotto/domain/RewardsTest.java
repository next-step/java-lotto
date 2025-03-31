package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RewardsTest {
    @Test
    @DisplayName("보상이 없는 객체 생성 불가")
    void create() {
        Assertions.assertThatThrownBy(() -> new Rewards(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1등이 1개 있으면 1리턴")
    void firstPrizeCount() {
        Rewards rewards = new Rewards(List.of(Reward.FIRST,
                Reward.SECOND,
                Reward.SECOND,
                Reward.THIRD,
                Reward.FOURTH
                ));
        Assertions.assertThat(rewards.firstPrizeCount())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("2등이 2개 있으면 2리턴")
    void secondPrizeCount() {
        Rewards rewards = new Rewards(List.of(Reward.FIRST,
                Reward.SECOND,
                Reward.SECOND,
                Reward.THIRD,
                Reward.FOURTH
                ));
        Assertions.assertThat(rewards.secondPrizeCount())
                .isEqualTo(2);
    }

    @Test
    @DisplayName("3등이 1개 있으면 1리턴")
    void thirdPrizeCount() {
        Rewards rewards = new Rewards(List.of(Reward.FIRST,
                Reward.SECOND,
                Reward.SECOND,
                Reward.THIRD,
                Reward.FOURTH
                ));
        Assertions.assertThat(rewards.thirdPrizeCount())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("4등이 1개 있으면 1리턴")
    void fourthPrizeCount() {
        Rewards rewards = new Rewards(List.of(Reward.FIRST,
                Reward.SECOND,
                Reward.SECOND,
                Reward.THIRD,
                Reward.FOURTH
                ));
        Assertions.assertThat(rewards.fourthPrizeCount())
                .isEqualTo(1);
    }
}
