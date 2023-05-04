package lotto3.domain;

import java.util.List;

public class LottoTicket {
  private final LottoNumbers numbers;

  public LottoTicket(List<Integer> numbers) {
    this.numbers = new LottoNumbers(numbers);
  }

  public List<Integer> getNumbers() {
    return numbers.getNumbers();
  }


  private int matchCount(WinningNumbers winningNumbers) {
    return numbers.countMatch(winningNumbers);
  }

  private boolean contains(BonusNumber bonusNumber) {
    return numbers.contains(bonusNumber);
  }

  public Prize getLottoPrize(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
    int matchCount = matchCount(winningNumbers);
    boolean containsBonusNumber = contains(bonusNumber);
    return Prize.valueOfMatchCountAndBonusNumber(matchCount, containsBonusNumber);
  }
}
