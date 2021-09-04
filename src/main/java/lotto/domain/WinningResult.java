package lotto.domain;

import java.util.List;

public class WinningResult {

  private final WinningStatistics statistics;
  private final RateOfReturn rateOfReturn;

  public WinningResult(List<Lotto> lottos, WinningInfo winningInfo) {
    statistics = new WinningStatistics(lottos, winningInfo);

    long inputMoney = lottos.size() * Lotto.PRICE.value();
    long totalPrizeMoney = statistics.totalPrizeMoney();
    rateOfReturn = new RateOfReturn(totalPrizeMoney, inputMoney);
  }

  public WinningStatistics statistics() {
    return statistics;
  }

  public double rateOfReturn() {
    return rateOfReturn.rate();
  }
}
