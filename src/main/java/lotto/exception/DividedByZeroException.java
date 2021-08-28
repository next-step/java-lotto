package lotto.exception;

public class DividedByZeroException extends IllegalArgumentException {

  public DividedByZeroException() {
    super("0으로 나눠질 수 없습니다.");
  }
}
