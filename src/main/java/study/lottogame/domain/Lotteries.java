package study.lottogame.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lotteries {

  private List<Lottery> lotteries;

  public Lotteries(final List<Lottery> lotteries) {
    this.lotteries = lotteries;
  }

  public GameResult calculateGameResult(Lottery prizeLottery, LottoNumber bonusLottoNumber) {
    Map<Rank, Integer> prizeStaticsMap = lotteries.stream()
        .map(lottery -> getRank(prizeLottery, bonusLottoNumber, lottery))
        .collect(Collectors.toMap(
            Function.identity(), r -> 1, Integer::sum, () -> new EnumMap<>(Rank.class))
        );

    return new GameResult(prizeStaticsMap);
  }

  private Rank getRank(Lottery prizeLottery, LottoNumber bonusLottoNumber, Lottery lottery) {
    int countOfMatch = lottery.matchLottoNumbers(prizeLottery);
    boolean matchBonus = lottery.matchLottoNumber(bonusLottoNumber);
    return Rank.valueOf(countOfMatch, matchBonus);
  }

  public List<Lottery> getLotteries() {
    return Collections.unmodifiableList(lotteries);
  }
}
