package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Price.inputMoney;

public class LottoResult {

  private final Map<LottoRank, Integer> numbersPerRank;
  private final double lottoRate;

  public LottoResult(List<LottoRank> lottoRecord) {
    this.numbersPerRank = numbersPerRank(lottoRecord);
    this.lottoRate = calculateRateOfReturn(lottoRecord);
  }

  public Map<LottoRank, Integer> numbersPerRank() {
    return numbersPerRank;
  }

  public double lottoRateOfReturn() {
    return lottoRate;
  }

  private double calculateRateOfReturn(List<LottoRank> lottoRecord) {
    return lottoRecord.stream().mapToDouble(LottoRank::prizeMoney).sum() / inputMoney(lottoRecord);
  }

  private Map<LottoRank, Integer> numbersPerRank(List<LottoRank> lottoRecord) {
    Map<LottoRank, Integer> numbersPerRankMap = new EnumMap<>(LottoRank.class);

    for (LottoRank lottoRank : LottoRank.lottoMatchedNumberList()) {
      numbersPerRankMap.put(lottoRank, matchedCountOfRank(lottoRecord, lottoRank));
    }

    return numbersPerRankMap;
  }

  private int matchedCountOfRank(List<LottoRank> lottoRecord, LottoRank lottoRankOfList) {
    return (int) lottoRecord.stream()
            .filter(lottoRank -> lottoRank.equalsPrizeMoney(lottoRankOfList))
            .count();
  }
}
