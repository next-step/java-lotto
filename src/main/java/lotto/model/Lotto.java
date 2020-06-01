package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  private final static int PRICE = 1000;

  private final List<LottoNumbers> lottoList;

  private Lotto(int money) {
    if (money < 0) {
      throw new IllegalArgumentException("돈은 음수일 수 없습니다.");
    }

    lottoList = new ArrayList<>();

    for (int i = 0; i < money / PRICE; i++) {
      lottoList.add(new LottoNumbers(LottoNumberPool.INSTANCE.quickPick()));
    }
  }

  public static Lotto newInstanceByMoney(int money) {
    return new Lotto(money);
  }

  public List<LottoNumbers> getLottoList() {
    return new ArrayList<>(lottoList);
  }
}
