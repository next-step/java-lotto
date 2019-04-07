package lotto.domain;

import java.util.Set;

public class WinNumbers {

  private final WinningNumbers winningNumbers;
  private final LottoNumber additionNumber;

  public WinNumbers(WinningNumbers winningNumbers, LottoNumber additionNumber) {

    this.winningNumbers = winningNumbers;

    if (winningNumbers.isContain(additionNumber)) {
      throw new IllegalArgumentException();
    }
    this.additionNumber = additionNumber;
  }

  public long matchCount(Set<LottoNumber> lottoNumbers) {
    return lottoNumbers.stream()
        .filter(winningNumbers::isContain)
        .count();
  }

  public boolean additionMatch(Set<LottoNumber> lottoNumbers) {
    return lottoNumbers.contains(additionNumber);
  }

  public static WinNumbers of(String inputWinNumbers, int inputAdditionNumber) {

    WinningNumbers winningNumbers = new WinningNumbers(LottoManualGenerator.generateLottoNumbers(inputWinNumbers));
    LottoNumber additionalNumber = LottoNumber.getInstance(inputAdditionNumber);

    return new WinNumbers(winningNumbers, additionalNumber);
  }
}
