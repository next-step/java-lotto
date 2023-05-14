package study.lottogame.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lotteries {

  private List<Lottery> lotteries;

  public Lotteries(final List<Lottery> lotteries) {
    this.lotteries = lotteries;
  }

  public GameResult calculateGameResult(WinningLottery winningLottery) {
    if(winningLottery == null){
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    EnumMap<Rank, Integer> prizeStaticsMap = lotteries.stream()
        .map(lottery -> winningLottery.getRank(lottery))
        .collect(Collectors.groupingBy(Function.identity(), () -> new EnumMap<>(Rank.class),
            Collectors.summingInt(value -> 1)));

    return new GameResult(prizeStaticsMap);
  }

  public void addLottery(Lottery lottery) {
    lotteries.add(lottery);
  }

  public List<Lottery> getLotteries() {
    return Collections.unmodifiableList(lotteries);
  }
}
