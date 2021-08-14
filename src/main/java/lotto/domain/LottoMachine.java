package lotto.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.service.LotteryDraw;
import lotto.strategy.GenerateLottoNumber;

public class LottoMachine {

  private static final int START_INCLUSIVE = 0;

  public static Lotteries createLottos(final PurchaseCount purchaseCount,
      final List<String> manualLottosNumbers) {
    return new Lotteries(
        Stream.of(createManualLottos(manualLottosNumbers),
                createAutoLottos(purchaseCount))
            .flatMap(Collection::stream)
            .collect(Collectors.toList()));
  }

  private static List<Lotto> createAutoLottos(final PurchaseCount purchaseCount) {
    return IntStream.range(START_INCLUSIVE, purchaseCount.getAutoCount())
        .mapToObj(number -> new Lotto(GenerateLottoNumber.createNumberPull()))
        .collect(Collectors.toList());
  }

  private static List<Lotto> createManualLottos(final List<String> manualLottos) {
    return manualLottos.stream()
        .map(LotteryDraw::inputWinningNumbers)
        .collect(Collectors.toList());
  }
}
