package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

  private static final int MAX_NUMBER = 45;
  private static final List<Integer> POOL = new ArrayList<>();
  private static final LottoNumberGenerator LOTTO_NUMBER_GENERATOR = new LottoNumberGenerator();


  private LottoNumberGenerator() {
  }

  public static LottoNumberGenerator getInstance() {
    for (int i = 1; i <= MAX_NUMBER; i++) {
      POOL.add(i);
    }
    return LOTTO_NUMBER_GENERATOR;
  }

  public List<Integer> generate() {
    List<Integer> shuffledList = new ArrayList<>(POOL);
    Collections.shuffle(shuffledList);
    return shuffledList.subList(0, 6);
  }
}
