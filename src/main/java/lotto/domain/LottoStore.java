package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoStore {

  private static final int LOTTO_PRICE = 1000;

  public static LottoGame sell(List<String> manualNumbers, Money money) {
    List<LottoBalls> manualLottoBalls = createManualLottoBalls(manualNumbers);
    int autoTryCount = money.calculateTryAutoLottoCount(manualNumbers.size(), LOTTO_PRICE);
    List<LottoBalls> autoLottoBalls = createAutoLottoBalls(autoTryCount);
    return createLottoGame(manualLottoBalls, autoTryCount, autoLottoBalls);
  }

  private static List<LottoBalls> createManualLottoBalls(List<String> manualNumbers) {
    List<LottoBalls> manualLottoBalls = new ArrayList<>();
    for (String manualNumber : manualNumbers) {
      manualLottoBalls.add(new LottoBalls(manualNumber));
    }
    return manualLottoBalls;
  }

  private static List<LottoBalls> createAutoLottoBalls(int autoTryCount) {
    return Stream.generate(() -> new LottoBalls(LottoBall.draw()))
        .limit(autoTryCount)
        .collect(Collectors.toList());
  }

  private static LottoGame createLottoGame(List<LottoBalls> manualLottoBalls, int autoTryCount,
      List<LottoBalls> autoLottoBalls) {
    return new LottoGame(
        manualLottoBalls.size(), autoTryCount,
        Stream.concat(manualLottoBalls.stream(), autoLottoBalls.stream())
            .collect(Collectors.toList())
    );
  }
}
