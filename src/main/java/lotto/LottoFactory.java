package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoFactory {

  private static final int START_INDEX = 0;
  private static final int LOTTO_MAX_COUNT = 6;
  private static final int MIN_VALUE = 1;

  private static final int MAX_VALUE = 45;

  public List<Integer> apply() {
    List<Integer> initNumbers = init();
    Collections.shuffle(initNumbers);
    return initNumbers.subList(START_INDEX, LOTTO_MAX_COUNT);
  }

  private List<Integer> init() {
    List<Integer> lottoNumbers = new ArrayList<>();
    for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
      lottoNumbers.add(i);
    }
    return lottoNumbers;
  }

}
