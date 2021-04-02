package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankPredicatesTest {

  @ParameterizedTest
  @CsvSource({"1, NONE", "2, NONE", "3, FIFTH","4, FOURTH", "6, FIRST"})
  @DisplayName("맞춘 개수를 통해서 올바른 LottoRank 값을 가져올 수 있는가")
  public void filterMatchCountTest(int value, String name) throws Exception {
    //given
    //when
    LottoRank lottoRank = LottoRankPredicates.filterLottRankIsDefault(value);
    //then
    assertEquals(lottoRank.name(), name);
  }

  @ParameterizedTest
  @CsvSource({"true, SECOND", "false, THIRD"})
  @DisplayName("보너스볼 맞춘 여부를 통해서 올바른 LottoRank 값을 가져올 수 있는가")
  public void filterBonusBallTest(boolean value, String name) throws Exception {
    //given
    //when
    LottoRank lottoRank = LottoRankPredicates.filterLottoRankIsSecondOrThird(value);
    //then
    assertEquals(lottoRank.name(), name);
  }

  @ParameterizedTest
  @ValueSource(strings = {"FIFTH", "FOURTH", "THIRD", "SECOND", "FIRST"})
  public void findRankTest(String value) throws Exception {
    //given
    //when
    LottoRank lottoRank = LottoRankPredicates.filterLottoRankWithString(value);
    //then
    assertEquals(lottoRank.name(), value);
  }
}