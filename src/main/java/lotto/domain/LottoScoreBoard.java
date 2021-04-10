package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;

public class LottoScoreBoard {
  private final LottoRanks lottoRanks;
  private final Money money;

  public LottoScoreBoard(LottoRanks lottoRanks, Money money) {
    this.lottoRanks = lottoRanks;
    this.money = money;
  }

  public static LottoScoreBoard createLottoResult(Money money, LottoRanks lottoRanks) {
    return new LottoScoreBoard(lottoRanks, money);
  }

  public double totalEarningRate() {
    return money.calculateEarningRate(getTotalWinningMoney(lottoRanks.getMatchResult()));
  }

  private int getTotalWinningMoney(Map<LottoRank, Long> map) {
    return map.entrySet()
        .stream()
        .mapToInt(this::getWinningMoney)
        .sum();
  }

  private int getWinningMoney(Entry<LottoRank, Long> entry) {
    return LottoRank.matchRankWinnerMoney(entry.getKey())
        .multiple(entry.getValue().intValue());
  }

  public String toResultString() {
    return "3개 일치 (5000원) - " + lottoRanks.toStringMatchCount(LottoRank.FIFTH) + "개\n"
        + "4개 일치 (50000원) - " + lottoRanks.toStringMatchCount(LottoRank.FOURTH) + "개\n"
        + "5개 일치 (1500000원) - " + lottoRanks.toStringMatchCount(LottoRank.THIRD) + "개\n"
        + "5개 일치, 보너스 볼 일치(30000000원) - " + lottoRanks.toStringMatchCount(LottoRank.SECOND) + "개\n"
        + "6개 일치 (2000000000원) - " + lottoRanks.toStringMatchCount(LottoRank.FIRST) + "개";
  }
}
