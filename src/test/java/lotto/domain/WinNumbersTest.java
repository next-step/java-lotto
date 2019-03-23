package lotto.domain;

import static lotto.domain.LottoTest.intArrayToLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.Test;

public class WinNumbersTest {

  @Test
  public void test_winNumber_matchCount() {

    // Given
    Set<LottoNumber> lottoNumbers = intArrayToLottoNumbers(4, 42, 14, 32, 28, 19);
    WinNumbers winNumbers = new WinNumbers(intArrayToLottoNumbers(1, 32, 10, 4, 26, 28));

    // When
    long matchCount = winNumbers.matchCount(lottoNumbers);

    // Then
    assertThat(matchCount).isEqualTo(3);
  }

  @Test
  public void test_winNumber_matchCount_zero() {

    // Given
    Set<LottoNumber> lottoNumbers = intArrayToLottoNumbers(4, 42, 14, 32, 28, 19);
    WinNumbers winNumbers = new WinNumbers(intArrayToLottoNumbers(1, 38, 10, 7, 17, 45));

    // When
    long matchCount = winNumbers.matchCount(lottoNumbers);

    // Then
    assertThat(matchCount).isEqualTo(0);
  }
}