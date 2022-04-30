package lotto.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public final class LottoFactory {

  private static final int LOTTO_MAX_COUNT = 6;
  private static final int MIN_VALUE = 1;
  private static final int MAX_VALUE = 45;
  private static LottoFactory instance;


  private LottoFactory() {
  }

  public static LottoFactory getInstance() {
    if (instance == null) {
      instance = new LottoFactory();
    }
    return LottoFactory.instance;
  }

  public Product apply() {
    return new Product(init());
  }

  private static Set<LottoNumber> init() {
    Set<LottoNumber> lottoNumbers = new HashSet<>();
    while (lottoNumbers.size() < LOTTO_MAX_COUNT) {
      lottoNumbers.add(
          new LottoNumber(
              new Random().nextInt(MAX_VALUE) + MIN_VALUE));
    }
    return lottoNumbers;
  }

}
