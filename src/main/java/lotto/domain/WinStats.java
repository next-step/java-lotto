package lotto.domain;

import java.util.List;

public class WinStats {

  private List<WinResult> winResults;

  public WinStats(List<WinResult> winResults) {
    this.winResults = winResults;
  }

  public Money totalReward() {

    return winResults.stream()
        .map(WinResult::reward)
        .reduce(Money::sum)
        .orElse(new Money(0));
  }

  public long getWinCount(WinMoney winMoney) {

    return winResults.stream()
        .filter(winResult -> winResult.isWinMoney(winMoney))
        .findFirst()
        .orElse(new WinResult(winMoney, 0))
        .getWinCount();
  }
}
