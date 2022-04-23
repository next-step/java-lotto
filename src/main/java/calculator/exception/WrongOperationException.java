package calculator.exception;

public class WrongOperationException extends RuntimeException{
  private static final String MESSAGE ="잘못된 부호를 넣었습니다. 다시 확인해주세요.";
  public WrongOperationException() {
    super(MESSAGE);
  }
}
