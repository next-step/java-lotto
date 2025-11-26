package lotto;

import java.util.Map;

public class LottoMachine {

  public static Lottos generateLottos(int count) {
    return LottoGenerator.generateLottos(count);
  }

  public static LottoResult generateResult(Map<Integer, Integer> matchResult,
      PurchaseAmount amount) {
    return new LottoResult(matchResult, amount);
  }

}
