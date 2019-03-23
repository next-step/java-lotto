package lotto.domain;

import static lotto.domain.LottoTest.intArrayToLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.Test;

public class WinMoneyTest {

  @Test
  public void test_isWinLotto_true() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    WinNumbers winNumbers = new WinNumbers(intArrayToLottoNumbers(1, 32, 10, 4, 26, 28));

    WinMoney winMoney = WinMoney.THREE;

    // When
    boolean result = winMoney.isWinLotto(lotto, winNumbers);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void test_isWinLotto_false() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));
    WinNumbers winNumbers = new WinNumbers(intArrayToLottoNumbers(1, 38, 10, 7, 17, 45));

    WinMoney winMoney = WinMoney.THREE;

    // When
    boolean result = winMoney.isWinLotto(lotto, winNumbers);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  public void test_totalWinMoney() {

    // Given
    WinMoney winMoney = WinMoney.THREE;
    long winCount = 3;

    // When
    Money totalWinMoney = winMoney.totalWinMoney(winCount);

    // Then
    assertThat(totalWinMoney).isNotNull();
    assertThat(totalWinMoney).isEqualTo(5_000 * winCount);
  }

  @Test
  public void test_totalWinMoney_zero() {

    // Given
    WinMoney winMoney = WinMoney.THREE;
    long winCount = 0;

    // When
    Money totalWinMoney = winMoney.totalWinMoney(winCount);

    // Then
    assertThat(totalWinMoney).isNotNull();
    assertThat(totalWinMoney).isEqualTo(0);
  }
}