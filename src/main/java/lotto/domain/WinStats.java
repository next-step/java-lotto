package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

  public String getYield() {
    return String.format("%.2f", totalReward().yield(buyMoney) * 100);
  }

  public List<Map<String, Object>> getWinResults() {
    return Arrays.stream(WinMoney.values())
        .map(winMoney -> {
          Map<String, Object> winResult = new HashMap<>();
          winResult.put("winMoney", winMoney);
          winResult.put("isBonus", winMoney == WinMoney.FIVE_BONUS);
          winResult.put("winCount", getWinCount(winMoney));

          return winResult;
        })
        .collect(Collectors.toList());
  }

  public long getWinCount(WinMoney winMoney) {
    return winResults.get(winMoney);
  }
}
