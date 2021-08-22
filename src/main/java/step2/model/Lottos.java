package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private final List<Lotto> lottos;

  public Lottos() {
    this.lottos = new ArrayList();
  }

  public Lotto getLotto(int index) {
    return lottos.get(index);
  }

  public int getLottosSize() {
    return lottos.size();
  }

  public void issueLottos(List<Integer> lottoNumbers) {
    lottos.add(new Lotto(lottoNumbers));
  }

  public void addLotto(Lotto lotto) {
    this.lottos.add(lotto);
  }
}
