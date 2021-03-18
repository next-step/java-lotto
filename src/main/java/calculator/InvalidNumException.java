package calculator;

public class InvalidNumException extends RuntimeException {

  public InvalidNumException() {
    super("양수만 연산할 수 있습니다.");
  }
}
