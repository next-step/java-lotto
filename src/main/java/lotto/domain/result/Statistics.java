package lotto.domain.result;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.game.Rank;

public class Statistics {

  private final Map<Rank, Integer> details;

  public Statistics(Map<Rank, Integer> details) {
    this.details = details;
  }

  @Override
  public String toString() {
    return Arrays.stream(Rank.values())
        .filter(x -> x != Rank.NONE)
        .map(
            e -> String.format("%s - %d개", e, details.getOrDefault(e, 0))
        ).collect(Collectors.joining("\n")) + "\n";
  }
}