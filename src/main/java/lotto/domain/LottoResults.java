package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {

  private List<LottoResult> lottoResults = new ArrayList<>();

  public LottoResults() {
  }

  public LottoResults(List<LottoResult> lottoResults) {
    this.lottoResults = lottoResults;
  }


  public long calculateTotalWinning(WinningLotto winningLotto) {
    return lottoResults.stream()
        .mapToLong(
            result -> result.calculateWinning(winningLotto))
        .sum();

  }

  public LottoResult findLottoResult(int count) {
    return lottoResults.stream()
        .filter(result -> result.matchesWinningNumber(count))
        .findFirst()
        .orElse(null);
  }

  public void addLottoResult(int winningCount) {
    lottoResults.add(new LottoResult(winningCount));
  }

  public int findTotalWinningCount(int winningNumber) {
    return lottoResults.stream()
        .mapToInt(result -> result.matchesWinningCount(winningNumber))
        .filter(count -> count != -1)
        .findFirst()
        .orElse(0);
  }
}
