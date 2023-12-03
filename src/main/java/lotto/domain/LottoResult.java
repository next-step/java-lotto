package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.enums.LottoResultType;

public class LottoResult {

  private final Map<LottoResultType, Lottos> result;

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
    double total = 0;
    for (LottoResultType lottoResultType : LottoResultType.values()) {
      if (lottoResultType.equals(LottoResultType.NO_MATCH)) {
        continue;
      }
      total += this.calculatePrice(lottoResultType);
    }
    return total / amount;
  }

  private double calculatePrice(LottoResultType lottoResultType) {
    return result.get(lottoResultType)
        .calculatePrice(lottoResultType);
  }

  public List<String> resultStatus() {
    return Arrays.stream(LottoResultType.values())
        .filter(each -> each != LottoResultType.NO_MATCH)
        .map(each -> each.resultMessage(result.get(each).size()))
        .collect(Collectors.toList());
  }
}
