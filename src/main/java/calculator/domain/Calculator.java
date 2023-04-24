package calculator.domain;

import calculator.domain.operator.CalculateOperateServiceLocator;
import calculator.domain.operator.CalculatorOperateService;
import java.util.ArrayDeque;
import java.util.EmptyStackException;
import util.CollectionUtils;

public class Calculator {

  private final CalculatorExpressionParser expressionParser;
  private final CalculateOperateServiceLocator operateServiceLocator;

  public Calculator() {
    this.expressionParser = new CalculatorExpressionParser();
    this.operateServiceLocator = new CalculateOperateServiceLocator();
  }

  public int calculate(String expression) {
    ArrayDeque<String> expressionStack = expressionParser.parse(expression);
    if (CollectionUtils.isEmpty(expressionStack)) {
      throw new IllegalArgumentException();
    }

    while(expressionStack.size() != 1) {
      final String left = expressionStack.pop();
      final String operator = expressionStack.pop();
      final String right = expressionStack.pop();
      final CalculatorValue calculatorValue = operateAtomicCalculation(left, operator, right);
      expressionStack.push(calculatorValue.getStringifiedValue());
    }

    return Integer.parseInt(expressionStack.pop());
  }

  private CalculatorValue operateAtomicCalculation (String left, String operatorStr, String right) {
    CalculatorValue leftValue = new CalculatorValue(left);
    CalculatorOperateService operator = operateServiceLocator.getOperatorByIcon(operatorStr);
    CalculatorValue rightValue = new CalculatorValue(right);
    return operator.operate(leftValue, rightValue);
  }
}
