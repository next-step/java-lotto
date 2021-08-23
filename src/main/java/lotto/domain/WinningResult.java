package lotto.domain;

import java.util.List;

public class WinningResult {

  private final WinningStatistics statistics;
  private final double rateOfReturn;

  public WinningResult(List<Lotto> lottos, Lotto winningLotto) {
    this.statistics = new WinningStatistics(lottos, winningLotto);
    this.rateOfReturn = calcRateOfReturn(lottos, statistics);
  }

  public WinningStatistics statistics() {
    return statistics;
  }

  public double rateOfReturn() {
    return rateOfReturn;
  }

  private double calcRateOfReturn(List<Lotto> lottos, WinningStatistics statistics) {
    long inputMoney = lottos.size() * LottoGame.LOTTO_PRICE.getValue();
    long totalPrizeMoney = statistics.calcTotalPrizeMoney();
    return ((double) totalPrizeMoney / inputMoney);
  }
}
