import java.util.Arrays;
import model.Calculator;
import model.Calculators;

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

    Calculators calculators = new Calculators(
        Arrays.asList(new Calculator(BASIC_SPLITER_COLON), new Calculator(BASIC_SPLITER_COMMA)));

    for (int i = 0; i < calculators.getCalculatorSize(); i++) {
      Calculator calculator = calculators.getCalculator(i);
      splitResult = calculator.split(expr);
    }

    return splitResult;
  }
}
