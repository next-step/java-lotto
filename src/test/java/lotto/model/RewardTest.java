package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lotto.enums.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardTest {

  @Test
  @DisplayName("당첨 번호가 몇개 일치 하는지 확인")
  void awardCount() {
    assertThat(Reward.matchCount(Set.of(1, 2, 3, 4, 5, 6), Set.of(1, 2, 3, 9, 10, 20)))
        .isEqualTo(3);
  }

  @Test
  @DisplayName("승리 수당 테스트")
  void winBenefit() {
//    Reward reward = new Reward();
//    reward = reward.winReward(Grade.FOURTH, 1);
//    reward = reward.winReward(Grade.THIRD, 2);
//    reward = reward.winReward(Grade.SECOND, 1);
//    reward = reward.winReward(Grade.FIRST, 1);
//    assertThat(reward).isEqualTo(new Reward(2001605000L));
  }
}