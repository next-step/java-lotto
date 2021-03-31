package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
  @Test
  @DisplayName("생성이 제대로 되는가")
  public void create() throws Exception {
    //given
    //when
    Money money = new Money(1000);
    //then
    assertEquals(money, new Money(1000));
  }

  @Test
  @DisplayName("입력 받은 금액을 토대로 로또의 개수만큼 구매할 수 있는가")
  public void dividePerLotto() throws Exception {
    //given
    Money money = new Money(14000);
    //when
    int perLotto = money.dividePerLotto();
    //then
    assertEquals(perLotto, 14);
  }

  @ParameterizedTest
  @CsvSource({"5000, 0.35", "50000, 3.57", "1500000, 107.14", "30000000, 2142.85", "2000000000, 142857.14"})
  @DisplayName("전체금액과 구매한 금액을 나눠서 수익률을 계산할 수 있는가")
  public void calculateEarningRate(int prize, String answer) throws Exception {
    //given
    Money money = new Money(14000);
    //when
    double earning = money.calculateEarningRate(prize);
    DecimalFormat df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.DOWN);
    //then
    assertEquals(df.format(earning), answer);
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
        () -> assertEquals(first.getWinnerMoney().calculateWinningMoney(value), 2000000000 * value),
        () -> assertEquals(second.getWinnerMoney().calculateWinningMoney(value), 30000000 * value),
        () -> assertEquals(third.getWinnerMoney().calculateWinningMoney(value), 1500000 * value),
        () -> assertEquals(fourth.getWinnerMoney().calculateWinningMoney(value), 50000 * value),
        () -> assertEquals(fifth.getWinnerMoney().calculateWinningMoney(value), 5000 * value)
    );
  }
}