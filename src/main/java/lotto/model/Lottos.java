package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private final List<Lotto> lottoList;

  public Lottos(List<Lotto> lottoList) {
    this.lottoList = new ArrayList<>(lottoList);
  }

  public List<Lotto> getLottoList() {
    return new ArrayList<>(lottoList);
  }

}
