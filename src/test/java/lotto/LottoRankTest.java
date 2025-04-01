package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

  @Test
  @DisplayName("당첨 갯수에 따라 등수를 반환한다")
  void getRank() {
    assertEquals(LottoRank.FIRST, LottoRank.valueOfMatchedCount(6));
    assertEquals(LottoRank.SECOND, LottoRank.valueOfMatchedCount(5));
    assertEquals(LottoRank.THIRD, LottoRank.valueOfMatchedCount(4));
    assertEquals(LottoRank.FOURTH, LottoRank.valueOfMatchedCount(3));
    assertEquals(LottoRank.MISS, LottoRank.valueOfMatchedCount(2));
  }

}