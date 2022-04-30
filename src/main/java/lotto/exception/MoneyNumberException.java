package lotto.exception;

public class MoneyNumberException extends RuntimeException {

  private static final String MESSAGE = "%d의 숫자를 입력하실 수 없습니다. 로또의 가격은 1000원입니다.";

  public MoneyNumberException(long value) {
    super(String.format(MESSAGE, value));
  }

}
