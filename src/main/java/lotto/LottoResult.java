package lotto;

import java.util.Map;

public class LottoResult {

  private final Map<LottoResultType,Lottos> result;

  private LottoResult(Map<LottoResultType, Lottos> result) {
    this.result = result;
  }

  public static LottoResult defaultOf(Map<LottoResultType, Lottos> result) {
    return new LottoResult(result);
  }

  public Lottos findTreeMatchResult(LottoResultType resultType) {
    return result.get(resultType);
  }

  public double calculateProfitRate(int amount) {
    Lottos lottosThree = result.get(LottoResultType.TREE);
    double three = lottosThree.calculatePrice(LottoResultType.TREE);
    Lottos lottosFour = result.get(LottoResultType.FOUR);
    double four = lottosFour.calculatePrice(LottoResultType.FOUR);
    Lottos lottosFive = result.get(LottoResultType.FIVE);
    double five = lottosFive.calculatePrice(LottoResultType.FIVE);
    Lottos lottosAll = result.get(LottoResultType.ALL);
    double all = lottosAll.calculatePrice(LottoResultType.ALL);
    double total = three + four + five + all;
    return total / amount;
  }
}
