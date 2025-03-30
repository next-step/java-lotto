package lotto.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoPrizeMatcherTest {

  @DisplayName("당첨 번호와 보너스 번호가 일치하는지 확인한다.")
  @Test
  void testFindPrize() {
    int matchCount = 5;
    boolean isBonus = true;

    assertThat(LottoPrizeMatcher.findPrize(matchCount, isBonus).get()).isEqualTo(LottoPrize.FIVE_MATCHES_WITH_BONUS);
  }

  @DisplayName("당첨 번호와 보너스 번호가 일치하지 않는 경우 확인한다.")
  @Test
  void testFindPrizeWhenNotMatch() {
    int matchCount = 1;
    boolean isBonus = false;

    assertThat(LottoPrizeMatcher.findPrize(matchCount, isBonus)).isEmpty();
  }

}