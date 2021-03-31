package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {

  @ParameterizedTest
  @CsvSource({"3, FIFTH", "4, FOURTH", "5, THIRD", "6, FIRST"})
  @DisplayName("5등, 4등, 3등, 1등을 제대로 검증을 하는가")
  public void matches(int matchResult, String key) throws Exception {
    //given
    LottoRank lottoRank = LottoRank.valueOf(matchResult, false);
    //when
    //then
    assertEquals(lottoRank.name(), key);
  }

  @Test
  @DisplayName("보너스 볼을 통해서 2등을 검증 할 수 있는가")
  public void matchSecond() throws Exception {
    //given
    //when
    LottoRank lottoRank = LottoRank.valueOf(5, true);
    //then
    assertEquals(lottoRank, LottoRank.SECOND);
  }

  @Test
  @DisplayName("None 체크를 제대로 하는가")
  public void isNull() throws Exception {
    assertTrue(LottoRank.isNone(LottoRank.NONE));
  }
}