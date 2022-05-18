package lotto.domain;

public class LottoGame {

  public static Rank match(Lotto lotto, WinLotto winLotto) {
    return winLotto.match(lotto);
  }

}
