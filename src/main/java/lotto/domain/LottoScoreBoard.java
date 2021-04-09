package lotto.domain;

import java.util.Map;
import java.util.Map.Entry;

public class LottoScoreBoard {

  private static final long INIT_VALUE = 0L;

  private final Map<LottoRank, Long> matchResultMap;
  private final Money money;

  public LottoScoreBoard(Map<LottoRank, Long> matchResultMap, Money money) {
    this.matchResultMap = matchResultMap;
    this.money = money;
  }

  public static LottoScoreBoard createLottoResult(Money money, LottoRanks lottoMatchResult) {
    return new LottoScoreBoard(lottoMatchResult.getMatchResult(), money);
  }

  public double totalEarningRate() {
    return money.calculateEarningRate(getTotalWinningMoney(matchResultMap));
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
    return "3개 일치 (5000원) - " + matchResultMap.getOrDefault(LottoRank.FIFTH, INIT_VALUE) + "개\n"
        + "4개 일치 (50000원) - " + matchResultMap.getOrDefault(LottoRank.FOURTH, INIT_VALUE) + "개\n"
        + "5개 일치 (1500000원) - " + matchResultMap.getOrDefault(LottoRank.THIRD, INIT_VALUE) + "개\n"
        + "5개 일치, 보너스 볼 일치(30000000원) - " + matchResultMap.getOrDefault(LottoRank.SECOND, INIT_VALUE) + "개\n"
        + "6개 일치 (2000000000원) - " + matchResultMap.getOrDefault(LottoRank.FIRST, INIT_VALUE) + "개";
  }
}
