package lotto.exception;

public class MoneyEmptyException extends RuntimeException{
  private static final String MESSAGE = "돈이 없어서 로또를 구매할 수 없습니다. 로또의 가격은 1000원입니다.";

  public MoneyEmptyException() {
    super(MESSAGE);
  }

}
