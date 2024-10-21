package calculator.constants;

import calculator.service.*;

import java.util.Arrays;

public enum Operator {
      PLUS("+", new Plus())
    , MINUS("-", new Minus())
    , MULTIPLICATION("*", new Multiplication())
    , DIVISION("/", new Division());

      private final String operator;
      private final CalculatorInterface calculatorInterface;

      Operator(String operator, CalculatorInterface calculatorInterface) {
          this.operator = operator;
          this.calculatorInterface = calculatorInterface;
      }

    private String getOperator() {
        return operator;
    }

    public CalculatorInterface getCalculatorInterface() {
        return calculatorInterface;
    }

    static public Operator find(String value) {
          return Arrays.stream(values())
                  .filter(operator -> operator.getOperator().equals(value))
                  .findAny()
                  .orElse(null);
    }

}
