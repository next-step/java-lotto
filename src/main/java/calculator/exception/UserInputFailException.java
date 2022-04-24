package calculator.exception;

public class UserInputFailException extends RuntimeException {

  private static final String FAIL_MESSAGE = "사용자 입력을 받는데 실패하였습니다.";

  public UserInputFailException() {
    super(FAIL_MESSAGE);
  }
}
