package study.lottogame.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lotteries {

  private List<Lottery> lotteries;

  public Lotteries(final List<Lottery> lotteries) {
    this.lotteries = lotteries;
  }

  public GameResult calculateGameResult(Lottery prizeLottery) {
    Map<Rank, Integer> prizeStaticsMap = new EnumMap<>(Rank.class);
    for (Lottery lottery : lotteries) {
      Rank rank = Rank.valueOf(lottery.matchLottoNumber(prizeLottery));
      prizeStaticsMap.merge(rank, 1, Integer::sum);
    }
    return new GameResult(prizeStaticsMap);
  }

  public List<Lottery> getLotteries() {
    return Collections.unmodifiableList(lotteries);
  }
}
