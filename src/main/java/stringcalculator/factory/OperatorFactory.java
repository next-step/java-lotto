package stringcalculator.factory;

import java.util.HashMap;
import java.util.Map;
import stringcalculator.domain.operatorImpl.AddOperator;
import stringcalculator.domain.operatorImpl.DivideOperator;
import stringcalculator.domain.operatorImpl.MultiplyOperator;
import stringcalculator.domain.Operator;
import stringcalculator.domain.operatorImpl.SubtractOperator;

public class OperatorFactory {

  private final Map<String, Operator> operatorMap;

  public OperatorFactory() {
    operatorMap = new HashMap();
    operatorMap.put("+", new AddOperator());
    operatorMap.put("-", new SubtractOperator());
    operatorMap.put("*", new MultiplyOperator());
    operatorMap.put("/", new DivideOperator());
  }

  public Operator create(final String operator) {
    if (!operatorMap.containsKey(operator)) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    return operatorMap.get(operator);
  }
}
