package stringcalculator.domain;

import java.util.HashMap;
import java.util.Map;
import stringcalculator.domain.operator.DivideOperator;
import stringcalculator.domain.operator.SubtractOperator;
import stringcalculator.domain.operator.MultiplyOperator;
import stringcalculator.domain.operator.Operator;
import stringcalculator.domain.operator.AddOperator;

public class OperatorMap {

  private Map<String, Operator> operatorMap = new HashMap();

  public OperatorMap() {
    operatorMap.put("+", new AddOperator());
    operatorMap.put("-", new SubtractOperator());
    operatorMap.put("*", new MultiplyOperator());
    operatorMap.put("/", new DivideOperator());
  }

  public Operator convertOperator(String input) {
    if (!operatorMap.containsKey(input)) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    return operatorMap.get(input);
  }
}
