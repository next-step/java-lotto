package lotto.domain.result;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.game.Rank;

public class GameResult {

  private final Map<Rank, Integer> ranks;

  public GameResult(List<Rank> rankList) {
    this.ranks = rankList.stream()
        .collect(Collectors.groupingBy(
            Function.identity(),
            Collectors.summingInt(e -> 1)
        ));
  }

  public GameResult(Map<Rank, Integer> ranks) {
    this.ranks = Map.copyOf(ranks);
  }

  public int getTotalPrize() {
    return ranks.entrySet().stream()
        .mapToInt(entry -> entry.getKey().calculatePrize(entry.getValue()))
        .sum();
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