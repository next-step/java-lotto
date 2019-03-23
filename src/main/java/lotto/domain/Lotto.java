package lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

  public final static int NUMBERS_SIZE = 6;

  private final Set<LottoNumber> lottoNumbers;

  public Lotto(Set<LottoNumber> lottoNumbers) {

    if (lottoNumbers.size() != NUMBERS_SIZE) {
      throw new IllegalArgumentException();
    }
    this.lottoNumbers = lottoNumbers;
  }

  public long matchCount(WinNumbers winNumbers) {
    return winNumbers.matchCount(lottoNumbers);
  }

  public String numbers() {

    return this.lottoNumbers.stream()
        .map(LottoNumber::toString)
        .collect(Collectors.joining(", "));
  }
}
