package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

  private final static int LOTTO_AMOUNT = 1_000;

  public static Lottos buy(int autoQuantity, List<Lotto> manualLottos) {

    LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();

    List<Lotto> lottos = new ArrayList<>();
    lottos.addAll(manualLottos);
    lottos.addAll(lottoAutoGenerator.generate(autoQuantity));
    return new Lottos(lottos);
  }

  public static int quantity(Money buyMoney) {
    return buyMoney.buy(LOTTO_AMOUNT);
  }
}
