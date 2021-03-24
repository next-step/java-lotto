package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {
  private static final Integer LOTTO_PRICE = 1000;

  public List<LottoGame> sell(Money money) {
    int count = money.getTryLottoCount(LOTTO_PRICE);
    return Stream.generate(LottoGame::new)
        .limit(count)
        .collect(Collectors.toList());
  }
}
