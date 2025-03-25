package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeTest {

  @DisplayName("일치 카운트에 따른 LottoPrize를 반환한다.")
  @Test
  void fromMatchCount() {
    assertEquals(LottoPrize.THREE_MATCHES, LottoPrize.fromMatchCount(3));
    assertEquals(LottoPrize.FOUR_MATCHES, LottoPrize.fromMatchCount(4));
    assertEquals(LottoPrize.FIVE_MATCHES, LottoPrize.fromMatchCount(5));
    assertEquals(LottoPrize.SIX_MATCHES, LottoPrize.fromMatchCount(6));
  }

  @DisplayName("일치 횟수에 따른 상태를 반환한다.")
  @Test
  void getPrizeAndCountStatus() {
    assertEquals("3개 일치 (5000원)- 1개", LottoPrize.THREE_MATCHES.getPrizeAndCountStatus(1));
    assertEquals("4개 일치 (50000원)- 1개", LottoPrize.FOUR_MATCHES.getPrizeAndCountStatus(1));
    assertEquals("5개 일치 (1500000원)- 1개", LottoPrize.FIVE_MATCHES.getPrizeAndCountStatus(1));
    assertEquals("6개 일치 (2000000000원)- 1개", LottoPrize.SIX_MATCHES.getPrizeAndCountStatus(1));
  }

  @DisplayName("일치 횟수에 따른 총 상금을 반환한다.")
  @Test
  void getTotalPrizeMoney() {
    assertEquals(5000, LottoPrize.THREE_MATCHES.getTotalPrizeMoney(1));
    assertEquals(50000, LottoPrize.FOUR_MATCHES.getTotalPrizeMoney(1));
    assertEquals(1500000, LottoPrize.FIVE_MATCHES.getTotalPrizeMoney(1));
    assertEquals(2000000000, LottoPrize.SIX_MATCHES.getTotalPrizeMoney(1));
  }
}