package lotto.domain;

import java.awt.event.WindowStateListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyLottos {

  private final List<Lotto> lottos;

  public MyLottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public WinStats winStats(WinNumbers winNumbers) {

    return new WinStats(winResults(winNumbers));
  }

  public List<WinResult> winResults(WinNumbers winNumbers) {

    return Arrays.stream(WinMoney.values())
        .map(winMoney -> countWinLotto(winNumbers, winMoney))
        .collect(Collectors.toList());
  }

  public WinResult countWinLotto(WinNumbers winNumbers, WinMoney winMoney) {

    long winCount = lottos.stream()
        .filter(lotto -> winMoney.isWinLotto(lotto, winNumbers))
        .count();

    return new WinResult(winMoney, winCount);
  }
}
