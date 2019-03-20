package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoVendingMachine {

  private static final int LOTTE_PRICE = 1000;

  private NumberGenerator numberGenerator;

  public LottoVendingMachine() {
    this.numberGenerator = new NumberGenerator();
  }

  public List<Lotto> purchaseLotto(Money purchaseAmount) {

    int issueCount = (int)purchaseAmount.amount() / LOTTE_PRICE;

    List<Lotto> lottoList = new ArrayList<>();
    for (int index = 0; index < issueCount; index++) {

      Lotto newLotto = new Lotto(numberGenerator.generate());
      lottoList.add(newLotto);
    }
    return lottoList;
  }
}
