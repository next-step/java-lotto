package lotto.domain;

import java.util.List;

public class LottoChecker {

  private LottoResults lottoResults = new LottoResults();
  private double profitRate = 0.0;

  public LottoChecker calculateResults(List<Lotto> lottos, WinningLotto winningLotto,
      int purchaseAmount) {

    checkPurchaseAmount(purchaseAmount);

    for (Lotto lotto : lottos) {
      int winningCount = winningLotto.matchingWinningNumber(lotto);
      updateWinningCount(winningCount);
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

    long totalWinning = lottoResults.calculateTotalWinningCount();

    return (double) totalWinning / purchaseAmount;
  }

  private void updateWinningCount(int winningCount) {
    LottoResult existingResult = lottoResults.findLottoResult(winningCount);
    if (existingResult != null) {
      existingResult.increaseTotalWinningCount();
    } else {
      lottoResults.addLottoResult(winningCount);
    }
  }

  public int findTotalWinningCount(int winningNumber) {
    return lottoResults.findTotalWinningCount(winningNumber);
  }

  public double getProfitRate() {
    return profitRate;
  }
}
