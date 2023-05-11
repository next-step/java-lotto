package study.lottogame.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lotteries {

  private List<Lottery> lotteries;

  public Lotteries(final List<Lottery> lotteries) {
    this.lotteries = lotteries;
  }

  public GameResult calculateGameResult(WinningLottery winningLottery) {
    Map<Rank, Integer> prizeStaticsMap = lotteries.stream()
        .map(lottery -> winningLottery.getRank(lottery))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(value -> 1)));

    return new GameResult(prizeStaticsMap);
  }

  public List<Lottery> getLotteries() {
    return Collections.unmodifiableList(lotteries);
  }
}
