package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSet {

  private final List<Lotto> lottos;
  private final int totalPrice;

  public LottoSet(int totalPrice, LottoGenerator lottoGenerator) {
    this.totalPrice = totalPrice;
    this.lottos = IntStream.range(0, totalPrice / Lotto.PRICE)
        .mapToObj(i -> Lotto.generateLotto(lottoGenerator))
        .collect(Collectors.toList());
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
