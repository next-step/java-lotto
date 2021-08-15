package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotteries {

  private final List<Lotto> lottos;

  public Lotteries(final List<Lotto> lottos) {
    this.lottos = Collections.unmodifiableList(lottos);
  }

  public List<Lotto> toList() {
    return new ArrayList<>(lottos);
  }
}
