package lotto.domain;

import java.util.List;

public class LottoSet {

  private final List<Lotto> lottos;

  public LottoSet(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public int size() {
    return lottos.size();
  }
}
