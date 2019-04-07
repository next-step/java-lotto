package lotto.domain;

import static lotto.domain.LottoTest.intArrayToLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class WinMoneyTest {

  @Test
  public void test_isWinLotto_true() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));

    WinningNumbers winningNumbers = new WinningNumbers(intArrayToLottoNumbers(1, 32, 10, 4, 26, 28));
    LottoNumber lottoNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winningNumbers, lottoNumber);

    WinMoney winMoney = WinMoney.THREE;

    // When
    WinMoney resultMoney = lotto.isWinLotto(winNumbers);

    // Then
    assertThat(resultMoney).isEqualTo(winMoney);
  }

  @Test
  public void test_isWinLotto_fiveWin_true() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));

    WinningNumbers winningNumbers = new WinningNumbers(intArrayToLottoNumbers(4, 42, 14, 32, 28, 21));
    LottoNumber lottoNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winningNumbers, lottoNumber);

    WinMoney winMoney = WinMoney.FIVE;

    // When
    WinMoney resultMoney = lotto.isWinLotto(winNumbers);

    // Then
    assertThat(resultMoney).isEqualTo(winMoney);
  }

  @Test
  public void test_isWinLotto_fiveOneWin_true() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));

    WinningNumbers winningNumbers = new WinningNumbers(intArrayToLottoNumbers(4, 42, 14, 32, 28, 21));
    LottoNumber lottoNumber = LottoNumber.getInstance(19);
    WinNumbers winNumbers = new WinNumbers(winningNumbers, lottoNumber);

    WinMoney winMoney = WinMoney.FIVE_BONUS;

    // When
    WinMoney resultMoney = lotto.isWinLotto(winNumbers);

    // Then
    assertThat(resultMoney).isEqualTo(winMoney);
  }

  @Test
  public void test_isWinLotto_false() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));

    WinningNumbers winningNumbers = new WinningNumbers(intArrayToLottoNumbers(1, 38, 10, 7, 17, 45));
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winningNumbers, additionNumber);

    // When
    WinMoney resultMoney = lotto.isWinLotto(winNumbers);

    // Then
    assertThat(resultMoney).isNull();
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
    assertThat(totalWinMoney).isEqualTo(new Money(5_000 * winCount));
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
    assertThat(totalWinMoney).isEqualTo(new Money(0));
  }
}