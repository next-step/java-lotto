package lotto.domain;

public class WinningLotto extends Lotto {

  private final LottoNumber bonusNumber;

  public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
    super(winningLotto.getNumbers(), LottoType.WINNING);

    validateBonusNumber(winningLotto, bonusNumber);
    this.bonusNumber = bonusNumber;
  }

  public LottoNumber getBonusNumber() {
    return bonusNumber;
  }

  private void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
    if (winningLotto.getNumbers().contains(bonusNumber)) {
      throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
  }

  public WinningRank calculateRank(Lotto lotto) {
    int matchCount = (int) this.matchCountWith(lotto);
    boolean matchBonus = lotto.contains(bonusNumber);
    return WinningRank.from(matchCount, matchBonus);
  }

  public long matchCountWith(Lotto lotto) {
    return lotto.getNumbers().stream()
        .filter(this.getNumbers()::contains)
        .count();
  }
}
