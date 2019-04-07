package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLottos {

  private final Money buyMoney;
  private final Lottos lottos;

  public MyLottos(Money buyMoney, Lottos lottos) {
    this.buyMoney = buyMoney;
    this.lottos = lottos;
  }

  public WinStats winStats(WinNumbers winNumbers) {
    return new WinStats(buyMoney, winResults(winNumbers));
  }

  public Map<WinMoney, Long> winResults(WinNumbers winNumbers) {

    Map<WinMoney, Long> winResult = new HashMap<>();

    Arrays.stream(WinMoney.values())
        .forEach(winMoney -> winResult.put(winMoney, lottos.countWinLotto(winNumbers, winMoney)));

    return winResult;
  }

  public int getBuyQuantity() {
    return this.lottos.getQuantity();
  }

  public List<Lotto> getLottos() {
    return this.lottos.getLottos();
  }
}
