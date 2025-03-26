package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

  private final LottoGenerator lottoGenerator;

  public LottoShop(LottoGenerator lottoGenerator) {
    this.lottoGenerator = lottoGenerator;
  }

  public Lottos buyLottos(PurchaseAmount purchaseAmount) {
    return generateLottos(purchaseAmount);
  }

  private Lottos generateLottos(PurchaseAmount purchaseAmount) {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < purchaseAmount.calculateLottoCount(); i++) {
      lottos.add(lottoGenerator.generate());
    }
    return new Lottos(lottos);
  }
}
