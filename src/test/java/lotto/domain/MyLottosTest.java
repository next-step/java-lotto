package lotto.domain;

import static lotto.domain.LottoTest.intArrayToLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class MyLottosTest {


  @Test
  public void test_yield_zeroMatch() {

    // Given
    Lotto lotto1 = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    Lotto lotto2 = new Lotto(intArrayToLottoNumbers(4, 30, 14, 32, 28, 19));
    Lotto lotto3 = new Lotto(intArrayToLottoNumbers(4, 15, 14, 32, 25, 19));
    Lotto lotto4 = new Lotto(intArrayToLottoNumbers(4, 42, 1, 15, 21, 19));
    MyLottos myLottos = new MyLottos(new Money(4000), Arrays.asList(lotto1, lotto2, lotto3, lotto4));

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(2, 13, 27, 41, 40, 5);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);
    WinStats winStats = myLottos.winStats(winNumbers);

    // When
    String yield = winStats.yield();

    // Then
    assertThat(yield).isEqualTo("0.00");
  }

  @Test
  public void test_yield_all_oneMatch() {

    // Given
    Lotto lotto1 = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    Lotto lotto2 = new Lotto(intArrayToLottoNumbers(4, 30, 14, 32, 28, 19));
    Lotto lotto3 = new Lotto(intArrayToLottoNumbers(4, 15, 14, 32, 25, 19));
    Lotto lotto4 = new Lotto(intArrayToLottoNumbers(4, 42, 1, 15, 21, 19));
    MyLottos myLottos = new MyLottos(new Money(4000), Arrays.asList(lotto1, lotto2, lotto3, lotto4));

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(19, 14, 28, 42, 32, 4);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);
    WinStats winStats = myLottos.winStats(winNumbers);

    // When
    String yield = winStats.yield();

    // Then
    assertThat(yield).isEqualTo("500388.75");
  }

  @Test
  public void test_winResults() {

    // Given
    Lotto lotto1 = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    Lotto lotto2 = new Lotto(intArrayToLottoNumbers(4, 30, 14, 32, 28, 19));
    Lotto lotto3 = new Lotto(intArrayToLottoNumbers(4, 15, 14, 32, 25, 19));
    Lotto lotto4 = new Lotto(intArrayToLottoNumbers(4, 42, 1, 15, 21, 19));
    MyLottos myLottos = new MyLottos(new Money(4000), Arrays.asList(lotto1, lotto2, lotto3, lotto4));

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(19, 14, 28, 42, 32, 4);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);

    // When
    Map<WinMoney, Long> winResults = myLottos.winResults(winNumbers);

    // Then
    assertThat(winResults).isNotNull();
    assertThat(winResults.size()).isEqualTo(5);
    assertThat(winResults.get(WinMoney.THREE)).isEqualTo(1);
    assertThat(winResults.get(WinMoney.FOUR)).isEqualTo(1);
    assertThat(winResults.get(WinMoney.FIVE)).isEqualTo(1);
    assertThat(winResults.get(WinMoney.FIVE_ONE)).isEqualTo(0);
    assertThat(winResults.get(WinMoney.SIX)).isEqualTo(1);
  }

  @Test
  public void test_winResults_sixMatch_one() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    MyLottos myLottos = new MyLottos(new Money(1000), Collections.singletonList(lotto));

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(19, 14, 28, 42, 32, 4);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);

    // When
    Map<WinMoney, Long> winResults = myLottos.winResults(winNumbers);

    // Then
    assertThat(winResults).isNotNull();
    assertThat(winResults.size()).isEqualTo(5);
    assertThat(winResults.get(WinMoney.THREE)).isEqualTo(0);
    assertThat(winResults.get(WinMoney.FOUR)).isEqualTo(0);
    assertThat(winResults.get(WinMoney.FIVE)).isEqualTo(0);
    assertThat(winResults.get(WinMoney.FIVE_ONE)).isEqualTo(0);
    assertThat(winResults.get(WinMoney.SIX)).isEqualTo(1);
  }

  @Test
  public void test_countWinLotto_sixMatch_zero() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(3, 1, 28, 41, 32, 26));
    MyLottos myLottos = new MyLottos(new Money(1000), Collections.singletonList(lotto));

    Set<LottoNumber> winLottoNumber = intArrayToLottoNumbers(19, 14, 28, 42, 32, 4);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumber, additionNumber);
    WinMoney winMoney = WinMoney.SIX;

    // When
    Long winCount = myLottos.countWinLotto(winNumbers, winMoney);

    // Then
    assertThat(winCount).isEqualTo(0);
  }

  @Test
  public void test_countWinLotto_threeMatch_one() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    MyLottos myLottos = new MyLottos(new Money(1000), Collections.singletonList(lotto));

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(19, 38, 10, 42, 17, 4);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);
    WinMoney winMoney = WinMoney.THREE;

    // When
    Long winCount = myLottos.countWinLotto(winNumbers, winMoney);

    // Then
    assertThat(winCount).isEqualTo(1);
  }

  @Test
  public void test_countWinLotto_zero() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    MyLottos myLottos = new MyLottos(new Money(1000), Collections.singletonList(lotto));

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(1, 38, 10, 7, 17, 45);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);

    WinMoney winMoney = WinMoney.THREE;

    // When
    Long winCount = myLottos.countWinLotto(winNumbers, winMoney);

    // Then
    assertThat(winCount).isEqualTo(0);
  }
}