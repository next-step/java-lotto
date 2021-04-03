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
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  public void matchFirst(boolean bonusBall) throws Exception {
    //given
    LottoRank lottoRank = LottoRank.valueOf(6, bonusBall);
    //when
    //then
    assertEquals(lottoRank.name(), "FIRST");
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
  @DisplayName("보너스 볼을 통해서 3등을 검증 할 수 있는가")
  public void matchThird() throws Exception {
    //given
    //when
    LottoRank lottoRank = LottoRank.valueOf(5, false);
    //then
    assertEquals(lottoRank, LottoRank.THIRD);
  }

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  public void matchFourth(boolean bonusBall) throws Exception {
    //given
    LottoRank lottoRank = LottoRank.valueOf(4, bonusBall);
    //when
    //then
    assertEquals(lottoRank.name(), "FOURTH");
  }

  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  public void matchFifth(boolean bonusBall) throws Exception {
    //given
    LottoRank lottoRank = LottoRank.valueOf(3, bonusBall);
    //when
    //then
    assertEquals(lottoRank.name(), "FIFTH");
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
        () -> assertEquals(LottoRank.getMatchRankWinnerMoney(first.name(), value),
            new Money(2000000000 * value)),
        () -> assertEquals(LottoRank.getMatchRankWinnerMoney(second.name(), value),
            new Money(30000000 * value)),
        () -> assertEquals(LottoRank.getMatchRankWinnerMoney(third.name(), value),
            new Money(1500000 * value)),
        () -> assertEquals(LottoRank.getMatchRankWinnerMoney(fourth.name(), value),
            new Money(50000 * value)),
        () -> assertEquals(LottoRank.getMatchRankWinnerMoney(fifth.name(), value),
            new Money(5000 * value))
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