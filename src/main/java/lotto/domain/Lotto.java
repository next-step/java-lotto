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

  public WinMoney isWinLotto(WinNumbers winNumbers) {
    return WinMoney.of(matchCount(winNumbers), additionMatch(winNumbers));

  }

  public long matchCount(WinNumbers winNumbers) {
    return winNumbers.matchCount(lottoNumbers);
  }


  public boolean additionMatch(WinNumbers winNumbers) {
    return winNumbers.additionMatch(lottoNumbers);
  }

  public String getNumbers() {

    return this.lottoNumbers.stream()
        .map(LottoNumber::toString)
        .collect(Collectors.joining(", "));
  }
}
