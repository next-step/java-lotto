package lotto.domain;

import java.util.List;

public class LottoMachine {

  public static LottoSet generateRandomLotto(int totalPrice) {
    return new LottoSet(totalPrice, new RandomLottoGenerator());
  }

  public static LottoSet generateManualLotto(List<Lotto> lottos) {
    return new LottoSet(lottos);
  }

}
