package lotto.domain;

import java.util.List;

public class Lottos {

  private final List<LottoNumbers> lottos;

  public Lottos(Amount amount) {
    this.lottos = LottoStore.generateLottos(amount.getAmount());
  }

  public List<LottoNumbers> getLottos() {
    return lottos;
  }
}
