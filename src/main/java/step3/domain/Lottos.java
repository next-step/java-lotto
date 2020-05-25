package step3.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {

  private final List<Lotto> lottoList;

  private Lottos(List<Lotto> lottoList) {
    this.lottoList = lottoList;
  }

  public static Lottos of (List<Lotto> lottoList) {
    return new Lottos(lottoList);
  }

  public long getPrice() {
    return lottoList.size() * Lotto.PRICE;
  }

  private Stream<Lotto> stream () {
    return lottoList.stream();
  }

  private long getLottoCount () {
    return lottoList.stream().count();
  }
}
