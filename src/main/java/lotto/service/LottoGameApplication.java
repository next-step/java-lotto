package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.PurchaseCount;
import lotto.strategy.GenerateLottoNumber;

public class LottoGameApplication {

  public static final int START_INCLUSIVE = 0;

  public static Lotteries createLottos(final PurchaseCount purchaseCount, final List<String> manualLottos) {

    List<Lotto> lottos = new ArrayList<>();

    createManualLottos(manualLottos, lottos);

    createAutoLottos(purchaseCount, lottos);

    return new Lotteries(lottos);
  }

  private static void createAutoLottos(final PurchaseCount purchaseCount, final List<Lotto> lottos) {
    IntStream.range(START_INCLUSIVE, purchaseCount.getAutoCount())
        .mapToObj(number -> new Lotto(GenerateLottoNumber.createNumberPull()))
        .forEach(lottos::add);
  }

  private static void createManualLottos(final List<String> manualLottos, final List<Lotto> lottos) {
    manualLottos.stream()
        .map(LotteryDraw::inputWinningNumbers)
        .forEach(lottos::add);
  }

}