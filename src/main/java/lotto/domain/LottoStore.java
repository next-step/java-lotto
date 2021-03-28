package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoStore {

  private static final Integer LOTTO_PRICE = 1000;

  public static LottoGame sell(Money money) {
    int count = money.calculateTryLottoCount(LOTTO_PRICE);
    return new LottoGame(
        Stream.generate(() -> new LottoBalls(LottoBall.draw()))
        .limit(count)
        .collect(Collectors.toList())
    );
  }
}
