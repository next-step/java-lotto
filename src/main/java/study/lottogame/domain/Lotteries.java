package study.lottogame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotteries {

  private List<Lottery> lotteries;

  public Lotteries(List<Lottery> lotteries) {
    this.lotteries = lotteries;
  }

  public Map<Rank, Integer> getWinningCountsByRank(Lottery winningLottery) {
    Map<Rank, Integer> winningCountsMap = new HashMap<>();
    for (Lottery lottery : lotteries) {
      int countOfMatch = lottery.matchLottoNumber(winningLottery);
      Rank rank = Rank.valueOf(countOfMatch);
      winningCountsMap.put(rank, winningCountsMap.getOrDefault(rank, 0) + 1);
    }
    return winningCountsMap;
  }

  public List<Lottery> getLotteries() {
    return lotteries;
  }
}
