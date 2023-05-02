package lotto3.domain;

import java.util.List;

public class LottoTicket {

  public static final int TICKET_PRICE = 1000;
  private final List<Integer> numbers;

  public LottoTicket(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }


  public int matchCount(WinningNumbers winningNumbers) {
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
