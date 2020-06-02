package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

  public static Lotto createLottoByQuickPick(Money money) {
    List<LottoNumbers> lottoList = new ArrayList<>();

    for (int i = 0; i < money.getValue() / Lotto.PRICE.getValue(); i++) {
      lottoList.add(new LottoNumbers(LottoNumberPool.INSTANCE.quickPick()));
    }

    return new Lotto(lottoList);
  }
}
