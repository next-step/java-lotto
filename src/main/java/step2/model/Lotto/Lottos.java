package step2.model.Lotto;

import java.util.List;

public class Lottos {

  private final List<Lotto> lottos;

  public Lottos(List lottos) {
    this.lottos = lottos;
  }

  public Lotto getLotto(int index) {
    return lottos.get(index);
  }

  public int getLottosSize() {
    return lottos.size();
  }
}
