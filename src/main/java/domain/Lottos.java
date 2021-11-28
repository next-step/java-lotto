package domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private List<Lotto> lottos;

  public Lottos() {
    this.lottos = new ArrayList();
  }

  public void addLotto(Lotto lotto) {
    this.lottos.add(lotto);
  }

  public List<Lotto> getLottos() {
    return new ArrayList(lottos);
  }

  public int getLottoCountAmount() {
    return this.lottos.size();
  }

}
