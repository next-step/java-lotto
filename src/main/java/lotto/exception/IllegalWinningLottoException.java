package lotto.exception;

public class IllegalWinningLottoException extends LottoException {

  public static final String WINNING_NUMBER_CANNOT_CONTAIN_BONUS_NUMBER = "보너스 번호는 우승 번호에 포함되어선 안됩니다.";

  public IllegalWinningLottoException() {
    super(WINNING_NUMBER_CANNOT_CONTAIN_BONUS_NUMBER);
  }
}
