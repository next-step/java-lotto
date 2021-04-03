package step3.domain;

import step3.domain.number.LottoMatchingNumber;
import step3.domain.number.LottoNumbers;

public class Lotto {
  private final LottoNumbers lottoNumbers;

  public Lotto(LottoNumbers lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
    lottoNumbers.sort();
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }

  public LottoMatchingNumber matchLotto(Lotto prizeLotto) {
    return lottoNumbers.matchNumbers(prizeLotto.lottoNumbers);
  }
}
