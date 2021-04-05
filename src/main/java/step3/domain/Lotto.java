package step3.domain;

import step3.domain.number.LottoMatchingCount;
import step3.domain.number.LottoNumber;
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

  public LottoMatchingCount matchLotto(Lotto prizeLotto) {
    return lottoNumbers.matchNumbers(prizeLotto.lottoNumbers);
  }

  public Boolean matchSpecificBall(LottoNumber bonusBall) {
    return lottoNumbers.matchSpecificNumber(bonusBall);
  }
}
