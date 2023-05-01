package lotto2.domain;

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


  public int matchCount(List<Integer> winningNumbers) {
    int count = 0;
    for (Integer number : numbers) {
      if (winningNumbers.contains(number)) {
        count++;
      }
    }
    return count;
  }
}
