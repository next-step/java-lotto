package lotto;

import java.util.HashSet;
import java.util.Set;

public final class Lotto {

  public static final int LOTTO_NUMBER_COUNT = 6;

  private final Set<LottoNumber> lottoNumbers;

  public Lotto() {
    lottoNumbers = new HashSet<>();
    for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
      lottoNumbers.add(new LottoNumber(1));
    }
  }

  public Set<LottoNumber> lottoNumbers() {
    return lottoNumbers;
  }
}
