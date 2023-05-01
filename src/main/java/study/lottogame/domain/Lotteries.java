package study.lottogame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotteries {

  private List<Lottery> lotteries;

  public Lotteries(final List<Lottery> lotteries) {
    this.lotteries = lotteries;
  }

  public GameResult calculateGameResult(Lottery prizeLottery) {
    Map<Rank, Integer> prizeStaticsMap = new HashMap<>();
    for (Lottery lottery : lotteries) {
      Rank rank = Rank.valueOf(lottery.matchLottoNumber(prizeLottery));
      prizeStaticsMap.put(rank, prizeStaticsMap.getOrDefault(rank, 0) + 1);
    }
    return new GameResult(prizeStaticsMap);
  }

  public List<Lottery> getLotteries() {
    return lotteries;
  }
}
