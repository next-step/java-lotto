package lotto;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

  private Map<Rank, Integer> sample;

  @BeforeEach
  void setUp() {
    this.sample = new HashMap<>();
    sample.put(Rank.FIRST, 0);
    sample.put(Rank.SECOND, 1);
    sample.put(Rank.THIRD, 0);
    sample.put(Rank.FOURTH, 0);
    sample.put(Rank.FIFTH, 1);
    sample.put(Rank.MISS, 0);
  }

  @Test
  void testSumExactly() {
    assertThat(Rank.calculateTotalReward(sample))
        .isEqualTo(Rank.SECOND.getWinningReward() + Rank.FIFTH.getWinningReward());
  }

  @Test
  @DisplayName("티켓에 보너스 번호를 같이 보냈을 때 정상적으로 2등을 체크 하는지 테스트")
  void testScoringSecond() {
    assertThat(Rank.getRewardFromNumHitWithBonusBall(5, true))
        .isEqualTo(Rank.SECOND.getWinningReward());
  }

  @Test
  @DisplayName("티켓에 보너스 번호를 같이 보냈을 때 정상적으로 3등을 체크 하는지 테스트")
  void testScoringWithBonusNumber() {
    assertThat(Rank.getRewardFromNumHitWithBonusBall(5, false))
        .isEqualTo(Rank.THIRD.getWinningReward());
  }
}
