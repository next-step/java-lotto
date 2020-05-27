package lotto.step4.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {

  private final List<Lotto> lottos;

  private Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public static Lottos of (List<Lotto> lottos) {
    return new Lottos(lottos);
  }

  public long getPrice() {
    return lottos.size() * Lotto.PRICE;
  }

  public static Lottos concat (Lottos lottos1, Lottos lottos2) {
    lottos1.lottos.addAll(lottos2.lottos);
    return lottos1;
  }

  public Stream<Lotto> stream () {
    return lottos.stream();
  }

}
