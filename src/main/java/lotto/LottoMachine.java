package lotto;

import java.util.List;

public class LottoMachine {

  public static List<Lotto> generateLottos(int count) {
    return LottoGenerator.generateLottos(count);
  }

  public static LottoResult generateResult(List<Lotto> lottos, Lotto winningNumbers,
      PurchaseAmount amount) {
    return new LottoResult(lottos, winningNumbers, amount);
  }

}
