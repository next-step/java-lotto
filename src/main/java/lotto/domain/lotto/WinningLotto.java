package lotto.domain.lotto;

import java.util.Objects;
import lotto.domain.Rank;
import lotto.exception.IllegalWinningLottoException;

public final class WinningLotto {

  private final Lotto lastWinningLotto;
  private final LottoNumber bonusNumber;

  public WinningLotto(Lotto lastWinningLotto, LottoNumber bonusNumber) {
    validateWinningLotto(lastWinningLotto, bonusNumber);
    this.lastWinningLotto = lastWinningLotto;
    this.bonusNumber = bonusNumber;
  }

  private void validateWinningLotto(Lotto lastWinningLotto, LottoNumber bonusNumber) {
    if (lastWinningLotto.contains(bonusNumber)) {
      throw new IllegalWinningLottoException();
    }
  }

  public LottoMatch compareLotto(Lotto lotto) {
    int matchCount = lastWinningLotto.countMatchNumbers(lotto);
    boolean isBonusNumberMatch = false;
    if (matchCount == Rank.FIVE.getMatchCount()) {
      isBonusNumberMatch = lotto.contains(bonusNumber);
    }
    return new LottoMatch(matchCount, isBonusNumberMatch);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WinningLotto)) {
      return false;
    }
    WinningLotto that = (WinningLotto) o;
    return Objects.equals(lastWinningLotto, that.lastWinningLotto) &&
        Objects.equals(bonusNumber, that.bonusNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastWinningLotto, bonusNumber);
  }
}
