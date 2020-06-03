package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

  public static Lottos createLottosByQuickPick(Money money) {
    List<Lotto> lottoList = new ArrayList<>();

    for (int i = 0; i < money.getValue() / Lotto.PRICE.getValue(); i++) {
      lottoList.add(new Lotto(LottoNumberPool.INSTANCE.quickPick()));
    }

    return new Lottos(lottoList);
  }
}
