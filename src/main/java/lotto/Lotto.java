package lotto;

import java.util.ArrayList;
import java.util.List;

public final class Lotto {

  public static final int LOTTO_NUMBER_COUNT = 6;

  private final List<LottoNumber> lottoNumbers;

  public Lotto() {
    lottoNumbers = new ArrayList<>();
    for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
      lottoNumbers.add(new LottoNumber(0));
    }
  }

  public List<LottoNumber> lottoNumbers() {
    return lottoNumbers;
  }
}
