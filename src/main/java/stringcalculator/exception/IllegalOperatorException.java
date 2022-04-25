package stringcalculator.exception;

public class IllegalOperatorException extends IllegalArgumentException {

  private static final String INVALID_OPERATOR_INPUT_ERR_MSG = "올바른 연산자가 아닙니다.(올바른 연산자: + - * /)";

  public IllegalOperatorException(String target) {
    super("[입력된 연산자:" + target + "]" + INVALID_OPERATOR_INPUT_ERR_MSG);
  }
}
