package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeTest {

  @DisplayName("일치 카운트에 따른 LottoPrize를 반환한다.")
  @Test
  void getPrizeFromMatchCount() {
    assertEquals(LottoPrize.THREE_MATCHES, LottoPrize.getPrizeFromMatchCount(3));
    assertEquals(LottoPrize.FOUR_MATCHES, LottoPrize.getPrizeFromMatchCount(4));
    assertEquals(LottoPrize.FIVE_MATCHES, LottoPrize.getPrizeFromMatchCount(5));
    assertEquals(LottoPrize.SIX_MATCHES, LottoPrize.getPrizeFromMatchCount(6));
  }

  @DisplayName("일치 카운트가 존재하지 않는 LottoPrize를 반환하면 예외를 발생한다.")
  @Test
  void getPrizeFromMatchCountException() {
    assertThatThrownBy(() -> LottoPrize.getPrizeFromMatchCount(2))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("일치하는 LottoPrize가 없습니다.");
  }

  @DisplayName("모든 일치 카운트를 반환한다.")
  @Test
  void getAllMatchCounts() {
    assertEquals(Set.of(3, 4, 5, 6), LottoPrize.getAllMatchCounts());
  }
}