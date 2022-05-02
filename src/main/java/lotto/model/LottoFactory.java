package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class LottoFactory {

  private static final int LOTTO_MAX_COUNT = 6;
  private static final int LOTTO_START_INDEX = 0;

  private static LottoFactory instance;
  private final List<Integer> init;

  private LottoFactory(List<Integer> init) {
    this.init = init;
  }

  public static LottoFactory getInstance(List<Integer> init) {
    if (instance == null) {
      instance = new LottoFactory(init);
    }
    return LottoFactory.instance;
  }

  public Lotto apply() {
    Collections.shuffle(init);
    return new Lotto(new HashSet<>(init.subList(LOTTO_START_INDEX, LOTTO_MAX_COUNT)));
  }


}
