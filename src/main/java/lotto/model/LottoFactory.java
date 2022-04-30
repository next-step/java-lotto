package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoFactory {

  private static final int START_INDEX = 0;
  private static final int LOTTO_MAX_COUNT = 6;
  private static final int MIN_VALUE = 1;
  private static final int MAX_VALUE = 45;

  public Product apply() {
    List<LottoNumber> initNumbers = init();
    Collections.shuffle(initNumbers);
    return new Product(new HashSet<>(initNumbers.subList(START_INDEX, LOTTO_MAX_COUNT)));
  }

  private List<LottoNumber> init() {
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
      lottoNumbers.add(new LottoNumber(i));
    }
    return lottoNumbers;
  }

}
