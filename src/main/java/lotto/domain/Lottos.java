package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

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

  @Override
  public String toString() {
    return values.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
  }
}
