package lotto.domain;

import java.awt.event.WindowStateListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyLottos {

  private final Money buyMoney;
  private final List<Lotto> lottos;

  public MyLottos(Money buyMoney, List<Lotto> lottos) {
    this.buyMoney = buyMoney;
    this.lottos = lottos;
  }

  public WinStats winStats(WinNumbers winNumbers) {
    return new WinStats(buyMoney, winResults(winNumbers));
  }

  public Map<WinMoney, Long> winResults(WinNumbers winNumbers) {

    Map<WinMoney, Long> winResult = new HashMap<>();

    Arrays.stream(WinMoney.values())
        .forEach(winMoney -> winResult.put(winMoney, countWinLotto(winNumbers, winMoney)));

    return winResult;
  }

  public Long countWinLotto(WinNumbers winNumbers, WinMoney winMoney) {

    return lottos.stream()
        .filter(lotto -> winMoney.isWinLotto(lotto, winNumbers))
        .count();
  }
}
