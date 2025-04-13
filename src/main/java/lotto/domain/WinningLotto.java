package lotto.domain;

import java.util.List;

public class WinningLotto {

  private LottoNumbers lottoNumbers = new LottoNumbers();
  private int bonusNumber;

  public WinningLotto(List<Integer> numbers) {
    lottoNumbers.createLottoNumbers(numbers);
  }

  public WinningLotto(List<Integer> numbers, int bonusNumber) {
    lottoNumbers.createLottoNumbers(numbers);
    this.bonusNumber = bonusNumber;

  }

  public PRIZES matchingWinningNumber(Lotto lotto) {
    int count = lotto.findCount(lottoNumbers);
    boolean containBonusBall = isContainBonusBall();
    return PRIZES.valueOf(count, containBonusBall);
  }

  public boolean isContainBonusBall() {
    return lottoNumbers.containBonusBall(bonusNumber);
  }
}
