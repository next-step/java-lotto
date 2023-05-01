package study.lottogame.domain;

import java.util.Map;

public class GameResult {

  private Map<Rank, Integer> prizeStaticsMap;
  private Money prizeMoney;

  public GameResult(final Map<Rank, Integer> prizeStaticsMap) {
    this.prizeStaticsMap = prizeStaticsMap;
    this.prizeMoney = calculatePrizeMoney(prizeStaticsMap);
  }

  private Money calculatePrizeMoney(final Map<Rank, Integer> prizeStaticsMap) {
    Money prizeMoney = new Money(0);
    for (Rank rank : Rank.values()) {
      Integer lotteryCount = prizeStaticsMap.getOrDefault(rank, 0);
      prizeMoney = prizeMoney.addMoney(new Money(rank.getWinningMoney() * lotteryCount));
    }
    return prizeMoney;
  }

  public Map<Rank, Integer> getPrizeStaticsMap() {
    return prizeStaticsMap;
  }

  public Money getPrizeMoney() {
    return prizeMoney;
  }
}
