package lotto.domain.result;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.game.Rank;
import lotto.domain.lotto.Money;

public class GameResult {

  private final Map<Rank, Integer> ranks;

  public GameResult(){
    this(new HashMap<>());
  }

  public GameResult(Map<Rank, Integer> ranks) {
    this.ranks = ranks;
  }

  public void updateRank(Rank rank) {
    ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
  }

  public Money getTotalPrize() {
    int total = ranks.entrySet().stream()
        .mapToInt(entry -> entry.getKey().calculatePrize(entry.getValue()))
        .sum();
    return new Money(total);
  }

  @Override
  public String toString() {
    return Arrays.stream(Rank.values())
        .filter(x -> x != Rank.NONE)
        .sorted(Comparator.reverseOrder())
        .map(e -> String.format("%s - %d개", e, ranks.getOrDefault(e, 0)))
        .collect(Collectors.joining("\n"));
  }
}