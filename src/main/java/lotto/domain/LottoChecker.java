package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {

  private final List<LottoResult> lottoResults = new ArrayList<>();
  private double profitRate = 0.0;

  public LottoChecker calculateResults(List<Lotto> lottos, WinningLotto winningLotto,
      int purchaseAmount) {

    checkPurchaseAmount(purchaseAmount);

    for (Lotto lotto : lottos) {
      int count = winningLotto.matchingWinningNumber(lotto);
      updateWinningCount(count);
    }

    this.profitRate = calculateProfitRate(purchaseAmount);
    return this;
  }

  private void checkPurchaseAmount(int purchaseAmount) {
    if (purchaseAmount < 0) {
      throw new IllegalArgumentException();
    }
  }

  private double calculateProfitRate(int purchaseAmount) {
    if (purchaseAmount == 0) {
      return 0.0;
    }

    long totalWinning = lottoResults.stream()
        .mapToLong(
            result -> PRIZES.getWinningMoneyByWinningNumber(result.getWinningsNumber()) * result
                .getTotalWinningCount())
        .sum();

    return (double) totalWinning / purchaseAmount;
  }

  private void updateWinningCount(int count) {
    LottoResult existingResult = findLottoResult(count);
    if (existingResult != null) {
      existingResult.increaseTotalWinningCount();
    } else {
      lottoResults.add(new LottoResult(count));
    }

  }

  private LottoResult findLottoResult(int count) {
    return lottoResults.stream()
        .filter(result -> result.getWinningsNumber() == count)
        .findFirst()
        .orElse(null);
  }

  public List<LottoResult> getLottoResults() {
    return lottoResults;
  }

  public double getProfitRate() {
    return profitRate;
  }
}
