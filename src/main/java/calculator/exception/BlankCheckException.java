package calculator.exception;

public class BlankCheckException extends RuntimeException{
  private static final String MESSAGE ="null 또는 공백을 입력하실 수 없습니다.";
  public BlankCheckException() {
    super(MESSAGE);
  }
}
