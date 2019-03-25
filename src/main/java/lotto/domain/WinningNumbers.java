package lotto.domain;

import java.util.Set;

public class WinningNumbers {

  private final Set<LottoNumber> winningNumbers;

  public WinningNumbers(Set<LottoNumber> winningNumbers) {
    if (winningNumbers.size() != Lotto.NUMBERS_SIZE) {
      throw new IllegalArgumentException();
    }

    this.winningNumbers = winningNumbers;
  }

  public boolean isContain(LottoNumber lottoNumber) {
    return winningNumbers.contains(lottoNumber);
  }
}
