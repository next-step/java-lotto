package stringcalculator.exception;

public class IllegalNumberException extends IllegalArgumentException {

  private static final String INPUT_NOT_NUMBER_ERR_MSG = "입력한 계산식의 피연산자가 숫자가 아닙니다.";

  public IllegalNumberException(String target) {
    super("[입력된 피연산자:" + target + "]" + INPUT_NOT_NUMBER_ERR_MSG);
  }
}
