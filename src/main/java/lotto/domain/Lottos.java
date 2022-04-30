package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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

  public List<Lotto> getValues() {
    return Collections.unmodifiableList(values);
  }

  public int size() {
    return values.size();
  }

  public LottoResult calculate(WinningLotto winningLotto) {
    Map<Rank, Integer> result = new EnumMap<>(Rank.class);
    for (Lotto lotto : values) {
      Rank rank = lotto.getRank(winningLotto);
      result.put(rank, result.getOrDefault(rank, 0) + 1);
    }
    return new LottoResult(result);
  }
}
