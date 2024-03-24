package lotto.domain;

import java.util.Set;

public class WinningNumbers {
  public static final String BONUS_BALL_CAN_NOT_SAME_AS_WINNING_NUMBER = "보너스 볼은 당첨 번호와 동일한 값을 가질 수 없습니다. winningNumbers: %s, bonusNumber: %s";

  private final LottoTicket winningNumber;
  private final Integer bonusNumber;

  private WinningNumbers(LottoTicket winningNumber, int bonusNumber) {
    valid(winningNumber, bonusNumber);
    this.winningNumber = winningNumber;
    this.bonusNumber = bonusNumber;
  }

  public static WinningNumbers of(Set<Integer> numbers, int bonusNumber) {
    return new WinningNumbers(LottoTicket.generate(numbers), bonusNumber);
  }

  public boolean isSame(Set<Integer> numbers) {
    return this.winningNumber.isSame(numbers);
  }

  public int matchNumberCount(LottoTicket myLottoTicket) {
    return winningNumber.getMatchCount(myLottoTicket);
  }

  public boolean isMatchBonusBall(LottoTicket myLottoTicket) {
    return myLottoTicket.contain(bonusNumber);
  }

  private void valid(LottoTicket winningNumber, int bonusNumber) {
    if (winningNumber.contain(bonusNumber)) {
      throw new IllegalArgumentException(String.format(BONUS_BALL_CAN_NOT_SAME_AS_WINNING_NUMBER, winningNumber, bonusNumber));
    }
  }
}
