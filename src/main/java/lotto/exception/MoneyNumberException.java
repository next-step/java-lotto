package lotto.exception;

public class MoneyNumberException extends RuntimeException {

  private static final String MESSAGE = "1000이하의 숫자를 입력하실 수 없습니다. %d는 입력할 수 없습니다.";

  public MoneyNumberException(long value) {
    super(String.format(MESSAGE, value));
  }

}
