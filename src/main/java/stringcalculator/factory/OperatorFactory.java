package stringcalculator.factory;

import java.util.HashMap;
import java.util.Map;
import stringcalculator.domain.Operator;

public class OperatorFactory {

  private static Map<String, Operator> operatorMap;

  static {
    operatorMap = new HashMap<>();
    operatorMap.put("+", Operator.ADD);
    operatorMap.put("-", Operator.SUBTRACT);
    operatorMap.put("*", Operator.MULTIPLY);
    operatorMap.put("/", Operator.DIVIDE);
  }

  private OperatorFactory() {
  }

  public static Operator create(final String operator) {
    if (!operatorMap.containsKey(operator)) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }
    return operatorMap.get(operator);
  }
}
