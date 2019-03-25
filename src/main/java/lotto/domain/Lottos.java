package lotto.domain;

import java.util.List;

public class Lottos {

  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public Long countWinLotto(WinNumbers winNumbers, WinMoney winMoney) {

    return lottos.stream()
        .filter(lotto -> winMoney == lotto.isWinLotto(winNumbers))
        .count();
  }
}
