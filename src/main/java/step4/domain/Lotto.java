package step4.domain;

import step4.domain.number.Count;
import step4.domain.number.LottoNumber;
import step4.domain.number.LottoNumbers;

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

  public Count matchLotto(Lotto prizeLotto) {
    return lottoNumbers.matchNumbers(prizeLotto.lottoNumbers);
  }

  public Boolean matchSpecificBall(LottoNumber bonusBall) {
    return lottoNumbers.matchSpecificNumber(bonusBall);
  }
}
