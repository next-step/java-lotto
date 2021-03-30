package step2.domain;

import step2.domain.number.Count;
import step2.domain.number.LottoNumbers;

public class Lotto {
  private final LottoNumbers lottoNumbers;

  public Lotto(LottoNumbers lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  @Override
  public String toString() {
    return lottoNumbers.sort().toString();
  }

  public Count matchLotto(Lotto prizeLotto){
    return lottoNumbers.matchNumbers(prizeLotto.lottoNumbers);
  }
}
