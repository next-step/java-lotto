package lotto.domain;

import java.util.List;

public class WinningResult {

  private final WinningSummary winningSummary;
  private final double profitRate;

  private WinningResult(WinningSummary winningSummary, double profitRate) {
    this.winningSummary = winningSummary;
    this.profitRate = profitRate;
  }

  public static WinningResult of(List<Lotto> lottos, WinningLotto winningLotto) {
    WinningSummary winningSummary = new WinningSummary();

    for (Lotto lotto : lottos) {
      PRIZES prize = winningLotto.matchingWinningNumber(lotto);
      if (prize != PRIZES.MISS) {
        winningSummary.add(prize);
      }
    }

    long totalWinning = winningSummary.calculateTotalWinning();

    int purchaseAmount = lottos.size() * Lottos.LOTTO_PRICE;
    double profitRate = purchaseAmount == 0 ? 0.0 : (double) totalWinning / purchaseAmount;

    return new WinningResult(winningSummary, profitRate);
  }

  public int getWinningCount(PRIZES prize) {
    return winningSummary.getCount(prize);
  }

  public double getProfitRate() {
    return profitRate;
  }

}
