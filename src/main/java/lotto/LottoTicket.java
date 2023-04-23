package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoTicket {
  private final List<Integer> numbers;

  public LottoTicket(List<Integer> numbers) {
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
