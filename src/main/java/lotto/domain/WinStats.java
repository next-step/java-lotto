package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinStats {

  private List<WinCount> winCounts;

  private final MyLottos myLottos;
  private final Set<Integer> winNumbers;

  public WinStats(MyLottos myLottos, Set<Integer> winNumbers) {
    this.myLottos = myLottos;
    this.winNumbers = winNumbers;

    total();
  }

  private void total() {

    this.winCounts = Arrays.stream(Prizes.values())
        .map(prizes -> new WinCount(prizes, winCount(prizes)))
        .collect(Collectors.toList());
  }

  public List<WinCount> getWinCounts() {
    return this.winCounts;
  }

  private long winCount(Prizes prizes) {

    return this.myLottos.getLottos().stream()
        .filter(lotto -> lotto.winMatch(this.winNumbers) == prizes.getMatchCount())
        .count();
  }

  public Money getTotalWinMoney() {

    return this.winCounts.stream()
        .map(WinCount::getWinMoney)
        .reduce(Money::sum)
        .get();
  }

  public String yield() {
    return myLottos.yield(getTotalWinMoney());
  }

}
