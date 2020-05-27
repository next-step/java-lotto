package lotto.step2.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {

  private final List<Lotto> lottoList;
  private final long price;

  private Lottos(List<Lotto> lottoList) {
    this.lottoList = lottoList;
    this.price = lottoList.size() * Lotto.PRICE;
  }

  public static Lottos of (List<Lotto> lottoList) {
    return new Lottos(lottoList);
  }

  public long getPrice() {
    return price;
  }

  public Stream<Lotto> stream () {
    return lottoList.stream();
  }
}
