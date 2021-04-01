package lotto.exception;

public class NegativeMoneyException extends LottoException {

  public static final String NEGATIVE_MONEY_NOT_ALLOWED = "금액은 음수일 수 없습니다.";

  public NegativeMoneyException() {
    super(NEGATIVE_MONEY_NOT_ALLOWED);
  }
}
