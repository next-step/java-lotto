package lotto.domain;

import static lotto.domain.LottoTest.intArrayToLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class MyLottosTest {

  @Test
  public void test_winResults() {

    // Given
    Lotto lotto1 = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    Lotto lotto2 = new Lotto(intArrayToLottoNumbers(4, 30, 14, 32, 28, 19));
    Lotto lotto3 = new Lotto(intArrayToLottoNumbers(4, 15, 14, 32, 25, 19));
    Lotto lotto4 = new Lotto(intArrayToLottoNumbers(4, 42, 1, 15, 21, 19));
    MyLottos myLottos = new MyLottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4));

    WinNumbers winNumbers = new WinNumbers(intArrayToLottoNumbers(19, 14, 28, 42, 32, 4));

    // When
    List<WinResult> winResults = myLottos.winResults(winNumbers);

    // Then
    assertThat(winResults).isNotNull();
    assertThat(winResults.size()).isEqualTo(4);
    assertThat(winResults.get(0).reward()).isEqualTo(new Money(5_000));
    assertThat(winResults.get(1).reward()).isEqualTo(new Money(50_000));
    assertThat(winResults.get(2).reward()).isEqualTo(new Money(1_500_000));
    assertThat(winResults.get(3).reward()).isEqualTo(new Money(2_000_000_000));
  }

  @Test
  public void test_winResults_sixMatch_one() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    MyLottos myLottos = new MyLottos(Collections.singletonList(lotto));

    WinNumbers winNumbers = new WinNumbers(intArrayToLottoNumbers(19, 14, 28, 42, 32, 4));

    // When
    List<WinResult> winResults = myLottos.winResults(winNumbers);

    // Then
    assertThat(winResults).isNotNull();
    assertThat(winResults.size()).isEqualTo(4);
    assertThat(winResults.get(0).reward()).isEqualTo(new Money(0));
    assertThat(winResults.get(1).reward()).isEqualTo(new Money(0));
    assertThat(winResults.get(2).reward()).isEqualTo(new Money(0));
    assertThat(winResults.get(3).reward()).isEqualTo(new Money(2_000_000_000));
  }

  @Test
  public void test_countWinLotto_sixMatch_zero() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(3, 1, 28, 41, 32, 26));
    MyLottos myLottos = new MyLottos(Collections.singletonList(lotto));

    WinNumbers winNumbers = new WinNumbers(intArrayToLottoNumbers(19, 14, 28, 42, 32, 4));
    WinMoney winMoney = WinMoney.SIX;

    // When
    WinResult winResult = myLottos.countWinLotto(winNumbers, winMoney);

    // Then
    assertThat(winResult).isNotNull();
    assertThat(winResult.reward()).isEqualTo(new Money(0));
  }

  @Test
  public void test_countWinLotto_threeMatch_one() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    MyLottos myLottos = new MyLottos(Collections.singletonList(lotto));

    WinNumbers winNumbers = new WinNumbers(intArrayToLottoNumbers(19, 38, 10, 42, 17, 4));
    WinMoney winMoney = WinMoney.THREE;

    // When
    WinResult winResult = myLottos.countWinLotto(winNumbers, winMoney);

    // Then
    assertThat(winResult).isNotNull();
    assertThat(winResult.reward()).isEqualTo(new Money(5_000));
  }

  @Test
  public void test_countWinLotto_zero() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    MyLottos myLottos = new MyLottos(Collections.singletonList(lotto));

    WinNumbers winNumbers = new WinNumbers(intArrayToLottoNumbers(1, 38, 10, 7, 17, 45));
    WinMoney winMoney = WinMoney.THREE;

    // When
    WinResult winResult = myLottos.countWinLotto(winNumbers, winMoney);

    // Then
    assertThat(winResult).isNotNull();
    assertThat(winResult.reward()).isEqualTo(new Money(0));
  }
}