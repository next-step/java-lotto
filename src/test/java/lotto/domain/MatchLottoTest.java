package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatchLottoTest {

  @ParameterizedTest
  @CsvSource({"3, FOURTH", "4, THIRD", "5, SECOND", "6, FIRST"})
  @DisplayName("제대로 검증을 하는가")
  public void matches(int matchResult, String key) throws Exception {
    //given
    MatchLotto matchLotto = MatchLotto.valueOf(matchResult);
    //when
    //then
    assertEquals(matchLotto.getWinnerRank(), key);
  }

  @Test
  @DisplayName("None 체크를 제대로 하는가")
  public void isNull() throws Exception {
    assertTrue(MatchLotto.isNone(MatchLotto.NONE));
  }
}