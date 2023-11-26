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

  public int findMatchResultCount(LottoResultType resultType) {
    return result.get(resultType).size();
  }

  public double calculateProfitRate(int amount) {
    double total = 0 ;
    for (LottoResultType lottoResultType : LottoResultType.values()) {
      total += this.calculatePrice(lottoResultType);
    }
    return total / amount;
  }
  private double calculatePrice(LottoResultType lottoResultType) {
    return result.get(lottoResultType)
                 .calculatePrice(lottoResultType);
  }
}
