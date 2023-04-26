package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Price.inputMoney;

public class LottoResult {

  private final List<LottoRank> lottoRecord;

  public LottoResult(List<LottoRank> lottoRecord) {
    this.lottoRecord = lottoRecord;
  }

  public double lottoRateOfReturn() {
    return lottoRecord.stream().mapToDouble(LottoRank::prizeMoney).sum() / inputMoney(lottoRecord);
  }

  public Map<LottoRank, Integer> numbersPerRank() {
    Map<LottoRank, Integer> numbersPerRankMap = new LinkedHashMap<>();

    for (LottoRank lottoRank : LottoRank.lottoMatchedNumberList()) {
      numbersPerRankMap.put(lottoRank, matchedCountOfRank(lottoRank));
    }

    return numbersPerRankMap;
  }

  private int matchedCountOfRank(LottoRank lottoRankOfList) {
    return (int) lottoRecord.stream()
            .filter(lottoRank -> lottoRank.equalsPrizeMoney(lottoRankOfList))
            .count();
  }
}
