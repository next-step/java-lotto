package lotto.domain;

import java.util.List;

public class WinningResult {

  private final WinningStatistics statistics;
  private final RateOfReturn rateOfReturn;

  public WinningResult(List<Lotto> lottos, Lotto winningLotto) {
    this.statistics = new WinningStatistics(lottos, winningLotto);

    long inputMoney = lottos.size() * Lotto.PRICE.value();
    long totalPrizeMoney = this.statistics.totalPrizeMoney();
    this.rateOfReturn = new RateOfReturn(totalPrizeMoney, inputMoney);
  }

  public WinningStatistics statistics() {
    return this.statistics;
  }

  public double rateOfReturn() {
    return this.rateOfReturn.rate();
  }
}
