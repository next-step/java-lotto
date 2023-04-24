package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Price.inputMoney;

public class LottoResult {

  private final List<LottoRank> lottoRecord;

  public LottoResult(List<LottoRank> lottoResults) {
    this.lottoRecord = lottoResults;
  }

  public double lottoRateOfReturn() {
    return lottoRecord.stream().mapToDouble(LottoRank::prizeMoney).sum() / inputMoney(lottoRecord);
  }

  public Map<Integer, Integer> numbersPerRank() {
    Map<Integer, Integer> numbersPerRankMap = new LinkedHashMap<>();

    for (int matchedCount : LottoRank.lottoMatchedNumberList()) {
      numbersPerRankMap.put(matchedCount, matchedCountOfRank(matchedCount));
    }

    return numbersPerRankMap;
  }

  private int matchedCountOfRank(int matchedCount) {
    return (int) lottoRecord.stream()
            .filter(lottoRank -> lottoRank.equalsMatchedCount(matchedCount))
            .count();
  }
}
