package lotto.domain;

import static lotto.domain.LottoTest.intArrayToLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.Test;

public class WinNumbersTest {

  @Test(expected = IllegalArgumentException.class)
  public void test_winNumber_additionNumber_containInWinNumbers() {

    // Given
    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(1, 32, 10, 4, 26, 28);
    LottoNumber additionNumber = LottoNumber.getInstance(10);

    // When
    new WinNumbers(winLottoNumbers, additionNumber);
  }

  @Test
  public void test_winNumber_matchCount() {

    // Given
    Set<LottoNumber> lottoNumbers = intArrayToLottoNumbers(4, 42, 14, 32, 28, 19);

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(1, 32, 10, 4, 26, 28);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);

    // When
    long matchCount = winNumbers.matchCount(lottoNumbers);

    // Then
    assertThat(matchCount).isEqualTo(3);
  }

  @Test
  public void test_winNumber_matchCount_zero() {

    // Given
    Set<LottoNumber> lottoNumbers = intArrayToLottoNumbers(4, 42, 14, 32, 28, 19);

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(1, 38, 10, 7, 17, 45);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);

    // When
    long matchCount = winNumbers.matchCount(lottoNumbers);

    // Then
    assertThat(matchCount).isEqualTo(0);
  }

  @Test
  public void test_winNumber_additionMatch() {

    // Given
    Set<LottoNumber> lottoNumbers = intArrayToLottoNumbers(4, 42, 14, 32, 28, 19);

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(1, 32, 10, 4, 26, 28);
    LottoNumber additionNumber = LottoNumber.getInstance(42);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);

    // When
    boolean isAdditionMatch = winNumbers.additionMatch(lottoNumbers);

    // Then
    assertThat(isAdditionMatch).isTrue();
  }

  @Test
  public void test_winNumber_additionMatch_fail() {

    // Given
    Set<LottoNumber> lottoNumbers = intArrayToLottoNumbers(4, 42, 14, 32, 28, 19);

    Set<LottoNumber> winLottoNumbers = intArrayToLottoNumbers(1, 32, 10, 4, 26, 28);
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winLottoNumbers, additionNumber);

    // When
    boolean isAdditionMatch = winNumbers.additionMatch(lottoNumbers);

    // Then
    assertThat(isAdditionMatch).isFalse();
  }
}