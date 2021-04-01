package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoStore {

  private static final int LOTTO_PRICE = 1000;

  public static LottoGame sell(int manualTryCount, Money money) {
    int autoTryCount = money.calculateTryAutoLottoCount(manualTryCount,LOTTO_PRICE);
    return new LottoGame(
        Stream.generate(() -> new LottoBalls(LottoBall.draw()))
            .limit(autoTryCount)
            .collect(Collectors.toList())
    );
  }
}
