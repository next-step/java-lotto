package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoStore {

  private static final Integer LOTTO_PRICE = 1000;

  public LottoGames sell(Money money) {
    int count = money.calculateTryLottoCount(LOTTO_PRICE);
    return new LottoGames(
        Stream.generate(() -> new LottoGame(new LottoBalls(LottoBall.draw())))
            .limit(count)
            .collect(Collectors.toList())
    );
  }
}
