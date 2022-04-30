package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.RandomNumberGenerateStrategy;

public class Lottos {

  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public static Lottos create(int numberOfPurchasedLotto) {
    List<Lotto> lottos = new ArrayList<>();
    for(int i = 0; i < numberOfPurchasedLotto; i++) {
      lottos.add(Lotto.create(new RandomNumberGenerateStrategy()));
    }
    return new Lottos(lottos);
  }

  public List<Lotto> getLottos() {
    return lottos;
  }
}
