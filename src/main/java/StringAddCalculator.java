import java.util.ArrayList;
import java.util.List;
import model.Calculator;

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

    String[] splitResult = {expr};

    List<Calculator> calculators = new ArrayList();
    calculators.add(new Calculator(BASIC_SPLITER_COLON));
    calculators.add(new Calculator(BASIC_SPLITER_COMMA));

    for (Calculator calculator : calculators) {
      splitResult = calculator.split(expr);
    }

    return splitResult;
  }
}
