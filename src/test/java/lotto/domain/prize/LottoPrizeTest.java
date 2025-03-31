package lotto.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoPrizeTest {

  @DisplayName("보너스 당첨 여부가 중요한 상금인지 확인한다.")
  @Test
  void testHasBonusVariant() {
    assertTrue(LottoPrize.FIVE_MATCHES_WITH_BONUS.hasBonusVariant());
    assertTrue(LottoPrize.FIVE_MATCHES.hasBonusVariant());
    assertFalse(LottoPrize.THREE_MATCHES.hasBonusVariant());
  }
}