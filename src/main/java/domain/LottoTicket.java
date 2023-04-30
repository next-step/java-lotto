package domain;

import java.util.List;

public class LottoTicket {

  public static final int PRICE = 1000;
  private final List<Integer> numbers;

  public LottoTicket(List<Integer> numbers) {
    this.numbers = numbers;
  }



  public List<Integer> numbers() {
    return numbers;
  }


  public int matchCount(List<Integer> winningNumbers) {
    int matchedCount = 0;
    for (Integer number : numbers) {
      if (winningNumbers.contains(number)) {
        matchedCount++;
      }
    }
    return matchedCount;
  }
}
