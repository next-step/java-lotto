package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import lotto.util.LottoNumberGenerator;
import lotto.util.ManualLottoNumberGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

  @ParameterizedTest
  @ValueSource(ints = {1,2,3,4,5,6})
  @DisplayName("상금 계산을 수행할 수 있는가")
  public void calculateWinningMoney(int value) throws Exception {
    //given
    LottoRank first = LottoRank.FIRST;
    LottoRank second = LottoRank.SECOND;
    LottoRank third = LottoRank.THIRD;
    LottoRank fourth = LottoRank.FOURTH;
    LottoRank fifth = LottoRank.FIFTH;

    //when
    //then
    assertAll("Test Calculate WinningMoney",
        () -> assertEquals(first.calculateWinningMoney(value), 2000000000 * value),
        () -> assertEquals(second.calculateWinningMoney(value), 30000000 * value),
        () -> assertEquals(third.calculateWinningMoney(value), 1500000 * value),
        () -> assertEquals(fourth.calculateWinningMoney(value), 50000 * value),
        () -> assertEquals(fifth.calculateWinningMoney(value), 5000 * value)
    );
  }

  @Test
  @DisplayName("Matches() 메서드를 통해 제대로 비교할 수 있는지")
  public void matches() throws Exception {
    //given
    List<Number> holdingNumbers = LottoNumberGenerator
        .from(new ManualLottoNumberGenerateStrategy(Arrays.asList(7, 6, 4, 3, 2, 1)));

    List<Number> winningNumbers = LottoNumberGenerator
        .from(new ManualLottoNumberGenerateStrategy(Arrays.asList(6, 5, 4, 3, 2, 1)));
    //when
    LottoRank expectedMatches = LottoRank.matches(holdingNumbers, winningNumbers, new Number(6));
    //then
    assertEquals(expectedMatches, LottoRank.SECOND);
  }
}