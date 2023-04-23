package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoTicket {
  private final List<Integer> numbers;

  public LottoTicket(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
    Collections.sort(numbers);
    this.numbers = numbers;
  }

  public int matchCount(Set<Integer> winningNumbers) {
    int matchCount = 0;
    for (Integer number : numbers) {
      if (winningNumbers.contains(number)) {
        matchCount++;
      }
    }
    return matchCount;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}
