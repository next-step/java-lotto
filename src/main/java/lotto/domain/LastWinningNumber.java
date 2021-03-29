package lotto.domain;

import java.util.Objects;

public final class LastWinningNumber {

  private final Lotto lastWinningLotto;
  private final LottoNumber bonusNumber;

  public LastWinningNumber(Lotto lastWinningLotto, LottoNumber bonusNumber) {
    this.lastWinningLotto = lastWinningLotto;
    this.bonusNumber = bonusNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LastWinningNumber)) {
      return false;
    }
    LastWinningNumber that = (LastWinningNumber) o;
    return Objects.equals(lastWinningLotto, that.lastWinningLotto) && Objects
        .equals(bonusNumber, that.bonusNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastWinningLotto, bonusNumber);
  }
}
