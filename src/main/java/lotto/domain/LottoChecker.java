package lotto.domain;

import java.util.List;

public class LottoChecker {

  private LottoResults lottoResults = new LottoResults();
  private double profitRate = 0.0;

  public LottoChecker calculateResults(List<Lotto> lottos, WinningLotto winningLotto,
      int purchaseAmount) {

    checkPurchaseAmount(purchaseAmount);

    PRIZES prizes = null;
    for (Lotto lotto : lottos) {
      prizes = winningLotto.matchingWinningNumber(lotto);
      updateWinningCount(prizes.getWinningsNumber());
    }

    this.profitRate = calculateProfitRate(purchaseAmount, winningLotto);
    return this;
  }

  private void checkPurchaseAmount(int purchaseAmount) {
    if (purchaseAmount < 0) {
      throw new IllegalArgumentException();
    }
  }

  private double calculateProfitRate(int purchaseAmount, WinningLotto winningLotto) {
    if (purchaseAmount == 0) {
      return 0.0;
    }

    long totalWinning = lottoResults.calculateTotalWinning(winningLotto);

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
