package lotto.exception;

public class NegativeMoneyException extends IllegalArgumentException {

  public NegativeMoneyException() {
    super("돈은 음수가 될 수 없습니다.");
  }
}
