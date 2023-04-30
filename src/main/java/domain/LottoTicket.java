package domain;

import java.util.List;

public class LottoTicket {

  public static final int PRICE = 1000;
  private final List<Integer> lottoNumbers;

  public LottoTicket(List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }


  public List<Integer> numbers() {
    return lottoNumbers;
  }


  public int getMatchCount(List<Integer> winningNumbers) {
    int matchedCount = 0;
    for (Integer number : lottoNumbers) {
      matchedCount = contains(winningNumbers, matchedCount, number);
    }
    return matchedCount;
  }

  private static int contains(List<Integer> winningNumbers, int matchedCount,
      Integer number) {
    if (winningNumbers.contains(number)) {
      matchedCount++;
    }
    return matchedCount;
  }
}
