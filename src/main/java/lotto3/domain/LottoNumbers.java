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
      count = findMatchCount(winningNumbers, count, number);
    }
    return count;
  }

  private static int findMatchCount(WinningNumbers winningNumbers, int count, Integer number) {
    if (winningNumbers.contains(number)) {
      count++;
    }
    return count;
  }

  public boolean contains(int bonusNumber) {
    return numbers.contains(bonusNumber);
  }
}
