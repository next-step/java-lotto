package lotto;

import java.util.List;

public class Lottos {

  private final List<Lotto> lottoList;

  public Lottos(List<Lotto> lottoList) {
    this.lottoList = lottoList;
  }

  public int getCount() {
    return lottoList.size();
  }

  public void printAllLottos() {
    lottoList.forEach(System.out::println);
  }
}

