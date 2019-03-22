package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {

  private static final int LOTTE_PRICE = 1_000;

  private NumberGenerator numberGenerator;

  public LottoVendingMachine() {
    this.numberGenerator = new NumberGenerator();
  }

  public MyLottos purchaseLotto(Money purchaseAmount) {

    int issueCount = (int)purchaseAmount.amount() / LOTTE_PRICE;

    List<Lotto> lottos = new ArrayList<>();
    for (int index = 0; index < issueCount; index++) {

      Lotto newLotto = new Lotto(numberGenerator.generate());
      lottos.add(newLotto);
    }
    return new MyLottos(purchaseAmount, lottos);
  }
}
