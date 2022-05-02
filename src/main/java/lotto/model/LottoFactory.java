package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import lotto.util.AwardNumberUtil;

public final class LottoFactory {
  private static final int LOTTO_MAX_COUNT = 6;
  private static final int LOTTO_START_INDEX = 0;
  private static LottoFactory instance;


  private LottoFactory() {
  }

  public static LottoFactory getInstance() {
    if (instance == null) {
      instance = new LottoFactory();
    }
    return LottoFactory.instance;
  }

  public Lotto apply(List<Integer> init) {
    Collections.shuffle(init);
    return new Lotto(new HashSet<>(init.subList(LOTTO_START_INDEX,LOTTO_MAX_COUNT)));
  }


}
