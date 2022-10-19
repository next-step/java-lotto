package domain;

import java.util.HashMap;
import java.util.Map;

public class OperatorMapping {

  private static Map<String, Operator> OperatorMap = new HashMap<>();

  static {
    OperatorMap.put("+", Operator.PLUS);
    OperatorMap.put("-", Operator.MINUS);
    OperatorMap.put("*", Operator.MULTIPLY);
    OperatorMap.put("/", Operator.DIVIDE);
  }

  public static Operator getOperator(String operator) {
    return OperatorMap.get(operator);
  }

}
