package domain;

import java.util.List;

public class LottoTicket {

  public static final int PRICE = 1000;
  private final List<Integer> numbers;

  public LottoTicket(List<Integer> numbers) {
    this.numbers = numbers;
  }

  public static int calculatePrize(int matchedCount) {
    if (matchedCount == 3) {
      return 5000;
    }
    if (matchedCount == 4) {
      return 50000;
    }
    if (matchedCount == 5) {
      return 1500000;
    }
    if (matchedCount == 6) {
      return 2000000000;
    }
    return 0;
  }

  public List<Integer> numbers() {
    return numbers;
  }

  public int matchCount(List<Integer> winningNumbers) {
    int matchedCount = 0;
    for (Integer number : numbers) {
      matchedCount = getMatchedCount(winningNumbers, matchedCount, number);
    }
    return matchedCount;
  }

  private static int getMatchedCount(List<Integer> winningNumbers, int matchedCount,
      Integer number) {
    if (winningNumbers.contains(number)) {
      matchedCount++;
    }
    return matchedCount;
  }
}
