package calculator.domain;

import calculator.domain.strategy.AdditionStrategy;
import calculator.domain.strategy.CalculateStrategy;

import java.util.List;
import java.util.Queue;

public class StringCalculator {

  private static final List<CalculateStrategy> calculateStrategies = List.of(new AdditionStrategy());

  private StringCalculator() {}

  public static int calculate(CalculatorQueue queue) {
    Queue<Operand> operandQueue = queue.getOperands();
    Queue<Operator> operatorQueue = queue.getOperators();

    int result = 0;
    Operand firstOperand = operandQueue.poll();

    while (!operatorQueue.isEmpty()) {
      Operand secondOperand = operandQueue.poll();
      Operator operator = operatorQueue.poll();

      for (CalculateStrategy calculateStrategy : calculateStrategies) {
        result = calculateStrategy.calculate(firstOperand, operator, secondOperand);
      }

      firstOperand = new Operand(result);
    }

    return result;
  }
}
