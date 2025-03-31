package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardTest {
    @Test
    @DisplayName("3개가 매칭되면 4등이다.")
    void matchCount() {
        Assertions.assertThat(Reward.valueOf(new MatchCount(3)))
                .isEqualTo(Reward.FOURTH);
    }
    @Test
    @DisplayName("4개가 매칭되면 3등이다.")
    void matchCount_1() {
        Assertions.assertThat(Reward.valueOf(new MatchCount(4)))
                .isEqualTo(Reward.THIRD);
    }
    @Test
    @DisplayName("5개가 매칭되면 2등이다.")
    void matchCount_2() {
        Assertions.assertThat(Reward.valueOf(new MatchCount(5)))
                .isEqualTo(Reward.SECOND);
    }
    @Test
    @DisplayName("6개가 매칭되면 1등이다.")
    void matchCount_3() {
        Assertions.assertThat(Reward.valueOf(new MatchCount(6)))
                .isEqualTo(Reward.FIRST);
    }
    @Test
    @DisplayName("2개 이하가 매칭되면 꽝이다.")
    void matchCount_4() {
        Assertions.assertThat(Reward.valueOf(new MatchCount(2)))
                .isEqualTo(Reward.NONE);
    }
}
