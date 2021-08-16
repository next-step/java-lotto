package step1;

public class StringAddCalculator {

  public static int splitAndSum(String expr) {
    int result = 0;
    if (expr == null || expr.isEmpty()) {
      return result;
    }

    Calculator calculator = new Calculator();
    return calculator.calculate(expr, Operator.PLUS);
  }
}
