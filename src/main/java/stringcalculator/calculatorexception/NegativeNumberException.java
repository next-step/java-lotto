package stringcalculator.calculatorexception;

public class NegativeNumberException extends IllegalArgumentException {

  public NegativeNumberException() {
    super("음수는 허용되지 않습니다.");
  }
}
