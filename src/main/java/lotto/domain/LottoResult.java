package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

  public static final int PER_TICKET = 1000;
  private final List<LottoRank> lottoRecord;

  public LottoResult(List<LottoRank> lottoResults) {
    this.lottoRecord = lottoResults;
  }

  public double lottoRateOfReturn() {
    return lottoRecord.stream().mapToDouble(LottoRank::prizeMoney).sum() / inputMoney();
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
            .filter(v -> v.equalsMatchedCount(matchedCount))
            .count();
  }

  private int inputMoney() {
    return lottoRecord.size() * PER_TICKET;
  }
}
