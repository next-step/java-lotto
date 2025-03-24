package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSet {

  private final List<Lotto> lottos;
  private final int totalPrice;

  public LottoSet(int totalPrice, RandomLottoGenerator lottoGenerator) {
    this.totalPrice = totalPrice;
    this.lottos = IntStream.range(0, totalPrice / Lotto.PRICE)
        .mapToObj(i -> Lotto.generateRandomLotto(lottoGenerator))
        .collect(Collectors.toList());
  }

  public LottoSet(List<Lotto> lottos) {
    this.lottos = lottos;
    this.totalPrice = lottos.size() * Lotto.PRICE;
  }

  public int size() {
    return lottos.size();
  }

  public int totalPrice() {
    return totalPrice;
  }

  public List<Lotto> getLottos() {
    return lottos;
  }
}
