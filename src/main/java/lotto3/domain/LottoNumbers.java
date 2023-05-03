package lotto3.domain;

import java.util.List;

public class LottoNumbers {

  private final List<Integer> numbers;

  public LottoNumbers(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public int countMatch(WinningNumbers winningNumbers) {
    return (int) numbers.stream().
        filter(winningNumbers::contains).
        count();
  }


  public boolean contains(BonusNumber bonusNumber) {
    return bonusNumber.contains(numbers);
  }
}
