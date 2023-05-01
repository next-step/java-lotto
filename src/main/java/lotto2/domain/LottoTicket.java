package lotto2.domain;

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




  public int findMatchingCount(List<Integer> winningNumbers) {
    int matchingCount = 0;
    for(Integer lottoNumber : lottoNumbers) {
      matchingCount = countMatched(winningNumbers, matchingCount, lottoNumber);
    }
    return matchingCount;
  }

  private static int countMatched(List<Integer> winningNumbers, int matchingCount,
      Integer lottoNumber) {
    if(winningNumbers.contains(lottoNumber)) {
      matchingCount++;
    }
    return matchingCount;
  }
}
