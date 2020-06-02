package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

  public static Lotto createLottoByQuickPick(int money) {
    if (money < 0) {
      throw new IllegalArgumentException("돈은 음수일 수 없습니다.");
    }

    List<LottoNumbers> lottoList = new ArrayList<>();

    for (int i = 0; i < money / Price.LOTTO.getPrice(); i++) {
      lottoList.add(new LottoNumbers(LottoNumberPool.INSTANCE.quickPick()));
    }

    return new Lotto(lottoList);
  }
}
