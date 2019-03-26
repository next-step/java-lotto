package lotto.domain;

import java.util.Map;

public class WinStats {

  private Money buyMoney;
  private Map<WinMoney, Long> winResults;

  public WinStats(Money buyMoney, Map<WinMoney, Long> winResults) {
    this.buyMoney = buyMoney;
    this.winResults = winResults;
  }

  public Money totalReward() {

    return winResults.entrySet().stream()
        .map(winResult -> winResult.getKey().totalWinMoney(winResult.getValue()))
        .reduce(Money::sum)
        .orElse(new Money(0));
  }

  public String yield() {
    return String.format("%.2f", totalReward().yield(buyMoney));
  }

  public long getWinCount(WinMoney winMoney) {
    return winResults.get(winMoney);
  }
}
