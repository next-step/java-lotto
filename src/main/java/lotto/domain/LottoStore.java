package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

  private final static int LOTTO_AMOUNT = 1_000;

  public static Lottos buy(int autoQuantity, List<Lotto> manualLottos) {

    List<Lotto> lottos = new ArrayList<>(manualLottos);

    LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator(autoQuantity);
    lottos.addAll(lottoAutoGenerator.generate());
    return new Lottos(lottos);
  }

  public static int quantity(Money buyMoney) {
    return buyMoney.buy(LOTTO_AMOUNT);
  }
}
