package lotto.domain;

import java.util.Set;

public class WinNumbers {

  private final Set<LottoNumber> winNumbers;
  private final LottoNumber additionNumber;

  public WinNumbers(Set<LottoNumber> winNumbers, LottoNumber additionNumber) {

    if (winNumbers.size() != Lotto.NUMBERS_SIZE) {
      throw new IllegalArgumentException();
    }

    this.winNumbers = winNumbers;
    this.additionNumber = additionNumber;
  }

  public long matchCount(Set<LottoNumber> lottoNumbers) {

    return winNumbers.stream()
        .filter(lottoNumbers::contains)
        .count();
  }
}
