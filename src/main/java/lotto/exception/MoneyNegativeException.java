package lotto.exception;

public class MoneyNegativeException extends RuntimeException {

  private static final String MESSAGE = "돈은 0미만의 숫자를 입력할 수 없습니다.";

  public MoneyNegativeException() {
    super(MESSAGE);
  }
}
