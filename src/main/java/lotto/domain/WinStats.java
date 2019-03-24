package lotto.domain;

import java.util.List;

public class WinStats {

  private Money buyMoney;
  private List<WinResult> winResults;

  public WinStats(Money buyMoney, List<WinResult> winResults) {
    this.buyMoney = buyMoney;
    this.winResults = winResults;
  }

  public Money totalReward() {

    return winResults.stream()
        .map(WinResult::reward)
        .reduce(Money::sum)
        .orElse(new Money(0));
  }

  public String yield() {
    return String.format("%.2f", totalReward().yield(buyMoney));
  }

  public long getWinCount(WinMoney winMoney) {

    return winResults.stream()
        .filter(winResult -> winResult.isWinMoney(winMoney))
        .findFirst()
        .orElse(new WinResult(winMoney, 0))
        .getWinCount();
  }
}
