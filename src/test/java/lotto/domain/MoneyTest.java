package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
  @DisplayName("제대로 나누기를 수행하는가")
  public void divide() throws Exception {
    //given
    Money money = new Money(14000);
    //when
    int perLotto = money.divide(1000);
    //then
    assertEquals(perLotto, 14);
  }

  @Test
  @DisplayName("제대로 곱하기를 수행하는가")
  public void multiple() throws Exception {
    //given
    Money money = new Money(20000);
    //when
    Money multiple = money.multiple(7);;
    //then
    assertEquals(new Money(140000), multiple);
  }

  @Test
  @DisplayName("List<Number> 의 합을 제대로 출력할 수 있는가")
  public void sumList() throws Exception {
    //given
    List<Money> monies = new ArrayList<>();
    //when
    monies.add(new Money(10000));
    monies.add(new Money(5000));
    //then
    assertEquals(Money.totalMonies(monies), 15000);
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
}