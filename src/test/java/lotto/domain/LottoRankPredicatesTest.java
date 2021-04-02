package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankPredicatesTest {

  @Test
  @DisplayName("LottoRank의 2등과 3등을 getSecondOrThird를 통해 판별 후 가져올 수 있는가")
  public void getSecondOrThirdTest() throws Exception {
    //given
    Predicate<LottoRank> lottoRankPredicate = LottoRankPredicates.getSecondOrThird(false);
    //when
    boolean expectedTest = lottoRankPredicate.test(LottoRank.THIRD);
    //then
    assertTrue(expectedTest);
  }

  @Test
  @DisplayName("LottoRank의 2,3등을 제외한 케이스를 판별 할 수 있는가")
  public void defaultCaseTest() throws Exception {
    //given
    Predicate<LottoRank> lottoRankPredicate = LottoRankPredicates.defaultCase(6);
    //when
    boolean test = lottoRankPredicate.test(LottoRank.FIRST);
    //then
    assertTrue(test);
  }

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
}