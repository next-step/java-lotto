package lotto;

public class LottoMachine {

  public static Lottos generateLottos(int count) {
    return LottoGenerator.generateLottos(count);
  }

  public static LottoResult generateResult(LottoMatchResult matchResult,
      PurchaseAmount amount) {
    return new LottoResult(matchResult, amount);
  }

}
