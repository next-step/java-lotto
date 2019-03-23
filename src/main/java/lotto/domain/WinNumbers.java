package lotto.domain;

import java.util.Set;

public class WinNumbers {

  private final Set<LottoNumber> winNumbers;

  public WinNumbers(Set<LottoNumber> winNumbers) {

    if (winNumbers.size() != Lotto.NUMBERS_SIZE) {
      throw new IllegalArgumentException();
    }

    this.winNumbers = winNumbers;
  }

  public long matchCount(Set<LottoNumber> lottoNumbers) {

    return winNumbers.stream()
        .filter(lottoNumbers::contains)
        .count();
  }
}
