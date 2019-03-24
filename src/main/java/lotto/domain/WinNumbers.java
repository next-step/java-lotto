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

    if (winNumbers.contains(additionNumber)) {
      throw new IllegalArgumentException();
    }
    this.additionNumber = additionNumber;
  }

  public long matchCount(Set<LottoNumber> lottoNumbers) {
    return winNumbers.stream()
        .filter(lottoNumbers::contains)
        .count();
  }

  public boolean additionMatch(Set<LottoNumber> lottoNumbers) {
    return lottoNumbers.contains(additionNumber);
  }
}
