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
    int count = 0;
    for (Integer number : numbers) {
      if (winningNumbers.contains(number)) {
        count++;
      }
    }
    return count;
  }

  public boolean contains(int bonusNumber) {
    return numbers.contains(bonusNumber);
  }
}
