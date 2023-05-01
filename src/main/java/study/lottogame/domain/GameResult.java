package study.lottogame.domain;

import java.util.Map;

public class GameResult {

  private Map<Rank, Integer> prizeStaticsMap;
  private Money prizeMoney;

  public GameResult(Map<Rank, Integer> prizeStaticsMap) {
    this(prizeStaticsMap, calculatePrizeMoney(prizeStaticsMap));
  }

  private static Money calculatePrizeMoney(Map<Rank, Integer> prizeStaticsMap) {
    Money prizeMoney = new Money(0);
    for (Rank rank : Rank.values()) {
      Integer lotteryCount = prizeStaticsMap.getOrDefault(rank, 0);
      prizeMoney = prizeMoney.addMoney(new Money(rank.getWinningMoney() * lotteryCount));
    }
    return prizeMoney;
  }

  private GameResult(Map<Rank, Integer> prizeStaticsMap, Money prizeMoney) {
    this.prizeStaticsMap = prizeStaticsMap;
    this.prizeMoney = prizeMoney;
  }

  public Map<Rank, Integer> getPrizeStaticsMap() {
    return prizeStaticsMap;
  }

  public Money getPrizeMoney() {
    return prizeMoney;
  }
}
