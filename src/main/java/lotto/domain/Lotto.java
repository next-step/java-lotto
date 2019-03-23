package lotto.domain;

import java.util.Set;

public class Lotto {

  public final static int NUMBERS_SIZE = 6;

  private final Set<LottoNumber> lottoNumbers;

  public Lotto(Set<LottoNumber> lottoNumbers) {

    if (lottoNumbers.size() != NUMBERS_SIZE) {
      throw new IllegalArgumentException();
    }
    this.lottoNumbers = lottoNumbers;
  }
}
