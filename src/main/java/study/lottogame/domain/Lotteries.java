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
      throw new IllegalArgumentException("당첨 로또번호와 보너스 로또번호는 필수 값입니다.");
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
