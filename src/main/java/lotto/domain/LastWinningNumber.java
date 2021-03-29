package lotto.domain;

import java.util.Objects;

public final class LastWinningNumber {

  public static final String WINNING_NUMBER_CANNOT_CONTAIN_BONUS_NUMBER = "보너스 번호는 우승 번호에 포함되어선 안됩니다.";

  private final Lotto lastWinningLotto;
  private final LottoNumber bonusNumber;

  public LastWinningNumber(Lotto lastWinningLotto, LottoNumber bonusNumber) {
    if (lastWinningLotto.contains(bonusNumber)) {
      throw new IllegalArgumentException(WINNING_NUMBER_CANNOT_CONTAIN_BONUS_NUMBER);
    }
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
