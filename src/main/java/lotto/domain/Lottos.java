package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

  private static final String LOTTOS_DELIMITER = "\n";

  private final List<Lotto> values;

  public Lottos(List<Lotto> values) {
    this.values = values;
  }

  public static Lottos autoCreate(int lottoCount) {
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < lottoCount; i++) {
      lottos.add(Lotto.autoCreate());
    }
    return new Lottos(lottos);
  }

  public int size() {
    return values.size();
  }

  public Map<Rank, Integer> calculate(Lotto winningLotto) {
    Map<Rank, Integer> result = new EnumMap<>(Rank.class);
    for (Lotto lotto : values) {
      Rank rank = lotto.getRank(winningLotto);
      result.put(rank, result.getOrDefault(rank, 0) + 1);
    }
    return result;
  }

  @Override
  public String toString() {
    return values.stream().map(Lotto::toString).collect(Collectors.joining(LOTTOS_DELIMITER));
  }
}
