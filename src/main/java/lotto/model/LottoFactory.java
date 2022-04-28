package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

  private static final int START_INDEX = 0;

  private static final int LOTTO_MAX_COUNT = 6;

  private static final int MIN_VALUE = 1;

  private static final int MAX_VALUE = 45;

  public Product apply() {
    List<LottoNo> initNumbers = init();
    Collections.shuffle(initNumbers);
    return new Product(initNumbers.subList(START_INDEX, LOTTO_MAX_COUNT));
  }

  private List<LottoNo> init() {
    List<LottoNo> lottoNumbers = new ArrayList<>();
    for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
      lottoNumbers.add(new LottoNo(i));
    }
    return lottoNumbers;
  }

}
