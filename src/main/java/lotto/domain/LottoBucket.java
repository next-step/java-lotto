package lotto.domain;

import lotto.enums.Rank;
import lotto.input.WinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class LottoBucket {

  private final List<Lotto> lottos;

  public LottoBucket(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public MatchNumberCount getMatchNumberCountWith(WinningNumber winningNumber) {
    Map<Rank, Long> rankCount = lottos
        .stream()
        .map(lotto -> lotto.getCalculatedRankBy(winningNumber))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    addRankNotIn(rankCount);

    return new MatchNumberCount(rankCount);
  }

  private void addRankNotIn(Map<Rank, Long> rankCount) {
    Arrays.stream(Rank.values())
        .filter(rank -> !rankCount.containsKey(rank))
        .forEach(rank -> rankCount.put(rank, 0L));
  }

  public int size() {
    return lottos.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoBucket that = (LottoBucket) o;
    return Objects.equals(lottos, that.lottos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottos);
  }
}
