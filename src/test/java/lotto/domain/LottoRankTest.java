package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoRankTest {

  @ParameterizedTest
  @DisplayName("1등인지 파악할 수 있는가")
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
  @DisplayName("4등인지 파악할 수 있는가")
  @ValueSource(booleans = {true, false})
  public void matchFourth(boolean bonusBall) throws Exception {
    //given
    LottoRank lottoRank = LottoRank.valueOf(4, bonusBall);
    //when
    //then
    assertEquals(lottoRank.name(), "FOURTH");
  }

  @ParameterizedTest
  @DisplayName("5등인지 파악할 수 있는가")
  @ValueSource(booleans = {true, false})
  public void matchFifth(boolean bonusBall) throws Exception {
    //given
    LottoRank lottoRank = LottoRank.valueOf(3, bonusBall);
    //when
    //then
    assertEquals(lottoRank.name(), "FIFTH");
  }

  @ParameterizedTest
  @DisplayName("입력된 String을 통해서 해당 등수의 상금을 알아낼 수 있는")
  @CsvSource({"FIRST , 2000000000", "SECOND, 30000000", "THIRD, 1500000", "FOURTH, 50000", "FIFTH, 5000"})
  public void findRankTest(String value, int prize) throws Exception {
    //given
    Money money = LottoRank.matchRankWinnerMoney(value);
    //when
    //then
    assertEquals(money, new Money(prize));
  }

  @Test
  @DisplayName("None 체크를 제대로 하는가")
  public void isNull() throws Exception {
    assertTrue(LottoRank.isNone(LottoRank.NONE));
  }

  @Test
  @DisplayName("Matches() 메서드를 통해 제대로 비교할 수 있는지")
  public void matches() throws Exception {
    //given
    Lotto holdingNumbers = Lotto.createManualLotto(Arrays.asList(7, 6, 4, 3, 2, 1));

    Lotto winningNumbers = Lotto.createManualLotto(Arrays.asList(6, 5, 4, 3, 2, 1));
    //when
    LottoRank expectedMatches = LottoRank.matches(holdingNumbers, winningNumbers, new Number(6));
    //then
    assertEquals(expectedMatches, LottoRank.SECOND);
  }
}