package study.lottogame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotteries {

  private List<Lottery> lotteries;

  public Lotteries(List<Lottery> lotteries) {
    this.lotteries = lotteries;
  }

  public GameResult calculateGameResult(Lottery prizeLottery) {
    Map<Rank, Integer> prizeStaticsMap = new HashMap<>();
    for (Lottery lottery : lotteries) {
      int countOfMatch = lottery.matchLottoNumber(prizeLottery);
      Rank rank = Rank.valueOf(countOfMatch);
      prizeStaticsMap.put(rank, prizeStaticsMap.getOrDefault(rank, 0) + 1);
    }
    return new GameResult(prizeStaticsMap);
  }

  public List<Lottery> getLotteries() {
    return lotteries;
  }
}
