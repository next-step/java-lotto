package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardTest {
    @Test
    @DisplayName("3개가 매칭되면 5등이다.")
    void matchCount() {
        Assertions.assertThat(Reward.valueOf(new MatchResult(3, false)))
                .isEqualTo(Reward.FIFTH);
    }
    @Test
    @DisplayName("4개가 매칭되면 4등이다.")
    void matchCount_0() {
        Assertions.assertThat(Reward.valueOf(new MatchResult(4, false)))
                .isEqualTo(Reward.FOURTH);
    }

    @Test
    @DisplayName("보너스 없이 5개가 매칭되면 3등이다.")
    void matchCount_1() {
        Assertions.assertThat(Reward.valueOf(new MatchResult(5, false)))
                .isEqualTo(Reward.THIRD);
    }
    @Test
    @DisplayName("5개가 매칭되고 보너스 번호까지 맞추면 2등이다.")
    void matchCount_2() {
        Assertions.assertThat(Reward.valueOf(new MatchResult(5,true)))
                .isEqualTo(Reward.SECOND);
    }
    @Test
    @DisplayName("6개가 매칭되면 1등이다.")
    void matchCount_3() {
        Assertions.assertThat(Reward.valueOf(new MatchResult(6,false)))
                .isEqualTo(Reward.FIRST);
    }
    @Test
    @DisplayName("2개 이하가 매칭되면 꽝이다.")
    void matchCount_4() {
        Assertions.assertThat(Reward.valueOf(new MatchResult(2, false)))
                .isEqualTo(Reward.NONE);
    }
}
