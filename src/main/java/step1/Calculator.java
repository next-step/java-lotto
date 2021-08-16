package step1;

public class Calculator {

  final static char BASIC_SPLITER_COMMA = ',';
  final static char BASIC_SPLITER_COLON = ':';
  final static char OR_OPERATOR_SYMBOL = '|';

  private String customSpliter;

  public Calculator() {
  }

  public Calculator(String spliter) {
    this.customSpliter = spliter;
  }

  public int calculate(String expr, Operator operator) {
    int result = 0;

    String[] splittedExpr = split(expr);

    for (int i = 0; i < splittedExpr.length; i++) {
      result = operator.calculate(result, Integer.parseInt(splittedExpr[i]));
    }

    return result;
  }

  public String[] split(String expr) {

    String[] tokens = expr
        .split("" + BASIC_SPLITER_COLON + OR_OPERATOR_SYMBOL + BASIC_SPLITER_COMMA);

    return tokens;
  }
}
