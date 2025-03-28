package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {

  public static LottoSet generateRandomLotto(LottoPurchase lottoPurchase) {
    return new LottoSet(lottoPurchase, new RandomLottoGenerator());
  }

  public static LottoSet generateManualLotto(LottoPurchase lottoPurchase, List<Lotto> lottos) {
    return new LottoSet(lottoPurchase, lottos);
  }

  public static LottoSet generateManualAndRandomLotto(LottoPurchase lottoPurchase, List<Lotto> manualLottos) {
    int manualCount = manualLottos.size();
    int autoCount = lottoPurchase.calculateLottoCount() - manualCount;

    List<Lotto> allLottos = Stream.concat(
            manualLottos.stream(),
            IntStream.range(0, autoCount)
                .mapToObj(i -> Lotto.generateRandomLotto(new RandomLottoGenerator()))
        )
        .collect(Collectors.toUnmodifiableList());

    return new LottoSet(lottoPurchase, allLottos);
  }
}
