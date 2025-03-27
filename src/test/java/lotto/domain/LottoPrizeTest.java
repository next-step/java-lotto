package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoPrizeTest {

  @DisplayName("일치 카운트와 보너스 여부에 따른 LottoPrize를 반환한다.")
  @Test
  void testGetPrizeFromMatchCount() {
    assertEquals(LottoPrize.THREE_MATCHES, LottoPrize.getPrizeFromMatchCount(3, false));
    assertEquals(LottoPrize.FOUR_MATCHES, LottoPrize.getPrizeFromMatchCount(4, false));
    assertEquals(LottoPrize.FIVE_MATCHES, LottoPrize.getPrizeFromMatchCount(5, false));
    assertEquals(LottoPrize.FIVE_MATCHES_WITH_BONUS, LottoPrize.getPrizeFromMatchCount(5, true));
    assertEquals(LottoPrize.SIX_MATCHES, LottoPrize.getPrizeFromMatchCount(6, false));
  }

  @DisplayName("일치 카운트가 존재하지 않는 LottoPrize를 반환하면 예외를 발생한다.")
  @Test
  void testGetPrizeFromMatchCountException() {
    assertThatThrownBy(() -> LottoPrize.getPrizeFromMatchCount(2, false))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("일치하는 LottoPrize가 없습니다.");
  }

  @DisplayName("일치 카운트 & 보너스가 존재하지 않는 LottoPrize를 반환하면 예외를 발생한다.")
  @Test
  void testGetPrizeFromMatchCountAndBonusException() {
    assertThatThrownBy(() -> LottoPrize.getPrizeFromMatchCount(4, true))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("일치하는 LottoPrize가 없습니다.");
  }

  @DisplayName("일치 카운트와 보너스 여부에 따른 LottoPrize가 존재하는지 확인한다.")
  @Test
  void testContainsPrizeMap() {
    assertTrue(LottoPrize.contains(3, false));
    assertTrue(LottoPrize.contains(4, false));
    assertTrue(LottoPrize.contains(5, false));
    assertTrue(LottoPrize.contains(5, true));
    assertTrue(LottoPrize.contains(6, false));

    assertFalse(LottoPrize.contains(2, false));
    assertFalse(LottoPrize.contains(3, true));
    assertFalse(LottoPrize.contains(4, true));
  }
}