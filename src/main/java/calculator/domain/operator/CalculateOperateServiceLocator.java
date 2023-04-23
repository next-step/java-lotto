package calculator.domain.operator;

import java.util.Arrays;
import java.util.List;

public class CalculateOperateServiceLocator {

  private final List<CalculatorOperateService> operators;

  public CalculateOperateServiceLocator () {
    this.operators = Arrays.asList(
        new CalculatorPlusOperator(),
        new CalculatorMinusOperator(),
        new CalculatorDivideOperator(),
        new CalculatorMultiplyOperator()
    );
  }

  public CalculatorOperateService getOperatorByIcon (String icon) {
    CalculatorOperator operator = CalculatorOperator.findByIcon(icon);
    if (operator == null) {
      throw new IllegalArgumentException();
    }

    return operators.stream()
        .filter(operatorStrategy -> operatorStrategy.getOperator() == operator)
        .findFirst()
        .orElseThrow(RuntimeException::new);
  }
}
