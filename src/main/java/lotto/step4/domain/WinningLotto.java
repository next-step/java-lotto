package lotto.step4.domain;

public class WinningLotto {

  private final Lotto winningLotto;
  private final LottoNumber bonusNumber;

  private WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
    this.winningLotto = lotto;
    this.bonusNumber = bonusNumber;
  }

  public static WinningLotto of (Lotto lotto, LottoNumber bonusNumber) {
    return new WinningLotto(lotto, bonusNumber);
  }

  public Rank getRankOfLotto (Lotto lotto) {
    long same = winningLotto.sameCount(lotto);
    boolean matchBonus = lotto.has(bonusNumber);
    return Rank.valueOf(same, matchBonus);
  }

}
