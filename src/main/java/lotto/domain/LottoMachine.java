package lotto.domain;

import java.util.List;

public class LottoMachine {

  public static LottoSet generateRandomLotto(LottoPurchase lottoPurchase) {
    return new LottoSet(lottoPurchase, new RandomLottoGenerator());
  }

  public static LottoSet generateManualLotto(LottoPurchase lottoPurchase, List<Lotto> lottos) {
    return new LottoSet(lottoPurchase, lottos);
  }

}
