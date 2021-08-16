public class StringAddCalculator {

  final static String BASIC_SPLITER_COMMA = ",";
  final static String BASIC_SPLITER_COLON = ":";

  public static int splitAndSum(String expr) {
    int result = 0;
    if (expr == null || expr.isEmpty()) {
      return result;
    }

    String[] exprs = splitExpr(expr);

    for (String num : exprs) {
      result += Integer.parseInt(num);
    }

    return result;
  }

  private static String[] splitExpr(String expr) {

    String[] result = {expr};

    if (expr.contains(BASIC_SPLITER_COMMA)) {
      result = expr.split(BASIC_SPLITER_COMMA);
    } else if (expr.contains(BASIC_SPLITER_COLON)) {
      result = expr.split(BASIC_SPLITER_COMMA);
    }

    return result;
  }
}
