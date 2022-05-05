package lotto.exception;

public class MoneyNumberException extends RuntimeException {

  private static final String MESSAGE = "%d원으로 로또를 구입하실 수 없습니다. 로또의 가격은 1000원입니다.";

  public MoneyNumberException(long value) {
    super(String.format(MESSAGE, value));
  }

}
