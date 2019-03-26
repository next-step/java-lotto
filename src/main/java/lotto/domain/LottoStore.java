package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoStore {

  private final static int LOTTO_AMOUNT = 1_000;

  public static Lottos buy(int autoQuantity, List<Lotto> manualLottos) {

    List<Lotto> lottos = new ArrayList<>();
    for(int buyIndex = 0; buyIndex < autoQuantity; buyIndex++) {

      Set<LottoNumber> lottoNumbers = LottoGenerator.generate();
      lottos.add(new Lotto(lottoNumbers));
    }
    lottos.addAll(manualLottos);
    return new Lottos(lottos);
  }

  public static int quantity(Money buyMoney) {
    return buyMoney.buy(LOTTO_AMOUNT);
  }
}
