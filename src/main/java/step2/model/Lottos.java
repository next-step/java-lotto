package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private final static int LOTTO_PRICE = 1000;

  private final List<Lotto> lottos;

  public Lottos() {
    this.lottos = new ArrayList();
  }

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public void purchase(int userAmount) {
    for (int i = 0; i < userAmount; i += LOTTO_PRICE) {
      this.lottos.add(new Lotto());
    }
  }

  public Lotto getLotto(int index) {
    return lottos.get(index);
  }

  public int getLottosSize() {
    return lottos.size();
  }

  public void calculateWinner(LottoWin lottoWin) {
    for (Lotto lotto : lottos) {
      lotto.calculateWin(lottoWin);
    }
  }
}
