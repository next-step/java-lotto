package lotto.domain;

import java.util.Objects;

public final class WinningLotto {

  public static final String WINNING_NUMBER_CANNOT_CONTAIN_BONUS_NUMBER = "보너스 번호는 우승 번호에 포함되어선 안됩니다.";

  private final Lotto lastWinningLotto;
  private final LottoNumber bonusNumber;

  public WinningLotto(Lotto lastWinningLotto, LottoNumber bonusNumber) {
    validateWinningLotto(lastWinningLotto, bonusNumber);
    this.lastWinningLotto = lastWinningLotto;
    this.bonusNumber = bonusNumber;
  }

  private void validateWinningLotto(Lotto lastWinningLotto, LottoNumber bonusNumber) {
    if (lastWinningLotto.contains(bonusNumber)) {
      throw new IllegalArgumentException(WINNING_NUMBER_CANNOT_CONTAIN_BONUS_NUMBER);
    }
  }

  public Lotto getLastWinningLotto() {
    return lastWinningLotto;
  }

  public LottoNumber getBonusNumber() {
    return bonusNumber;
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
