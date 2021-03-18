package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LastWinningLotto {

  private Lotto lotto;
  private LottoNumber bonusBall;

  public LastWinningLotto(Lotto lotto, LottoNumber bonusBall) {
    this.lotto = lotto;
    this.bonusBall = bonusBall;
  }

  public static LastWinningLotto of(List<Integer> numbers,int bonusBall) {
    return new LastWinningLotto(Lotto.of(numbers),new LottoNumber(bonusBall));
  }

  public boolean contains(LottoNumber lottoNumber) {
    return lotto.contains(lottoNumber);
  }

  public boolean matchBonusBall(LottoNumber lottoNumber) {
    return bonusBall.equals(lottoNumber);
  }
}
