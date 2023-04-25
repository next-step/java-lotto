package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoTicket {
  public static final int PRICE = 1_000;
  private final List<Integer> numbers;

  public LottoTicket(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
    Collections.sort(numbers);
    this.numbers = numbers;
  }

  public LottoTicket(Set<Integer> numbers) {
    this(new ArrayList<>(numbers));
  }

  public int matchCount(LottoTicket winningNumbers) {
    int matchCount = 0;
    for (Integer number : numbers) {
      if (winningNumbers.contains(number)) {
        matchCount++;
      }
    }
    return matchCount;
  }

  private boolean contains(Integer number) {
    return numbers.contains(number);
  }

  public List<Integer> getNumbers() {
    return numbers;
  }
}
