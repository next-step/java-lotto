package calculator.exception;

public class InvalidFormulaException extends RuntimeException {

  private static final String INVALID_FORMULA_MESSAGE = "잘못된 계산식입니다.";

  public InvalidFormulaException(Exception e) {
    super(INVALID_FORMULA_MESSAGE, e);
  }
}
