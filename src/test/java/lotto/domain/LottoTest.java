package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class LottoTest {

  @Test(expected = IllegalArgumentException.class)
  public void test_lotto_constructor_one_lottoNumbers() {

    // Given
    Set<LottoNumber> lottoNumbers = intArrayToLottoNumbers(4);

    // When
    new Lotto(lottoNumbers);
  }

  @Test
  public void test_lotto_constructor_six_lottoNumbers() {

    // Given
    Set<LottoNumber> lottoNumbers = intArrayToLottoNumbers(4, 42, 14, 32, 28, 19);

    // When
    Lotto lotto = new Lotto(lottoNumbers);

    // Then
    assertThat(lotto).isNotNull();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_lotto_constructor_seven_lottoNumbers() {

    // Given
    Set<LottoNumber> lottoNumbers = intArrayToLottoNumbers(4, 42, 14, 32, 28, 19, 1);

    // When
    new Lotto(lottoNumbers);
  }

  @Test
  public void test_lotto_matchCount() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));

    WinningNumbers winningNumbers = new WinningNumbers(intArrayToLottoNumbers(1, 32, 10, 4, 26, 28));
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winningNumbers, additionNumber);

    // When
    long matchCount = lotto.matchCount(winNumbers);

    // Then
    assertThat(matchCount).isEqualTo(3);
  }

  @Test
  public void test_lotto_matchCount_zero() {

    // Given
    Lotto lotto = new Lotto(intArrayToLottoNumbers(4, 42, 14, 32, 28, 19));

    WinningNumbers winningNumbers = new WinningNumbers(intArrayToLottoNumbers(1, 38, 10, 7, 17, 45));
    LottoNumber additionNumber = LottoNumber.getInstance(23);
    WinNumbers winNumbers = new WinNumbers(winningNumbers, additionNumber);

    // When
    long matchCount = lotto.matchCount(winNumbers);

    // Then
    assertThat(matchCount).isEqualTo(0);
  }

  public static Set<LottoNumber> intArrayToLottoNumbers(int... numbers) {

    return Arrays.stream(numbers)
        .mapToObj(LottoNumber::getInstance)
        .collect(Collectors.toSet());
  }
}