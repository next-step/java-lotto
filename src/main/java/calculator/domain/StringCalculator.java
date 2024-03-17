package calculator.domain;

import calculator.domain.strategy.AdditionStrategy;
import calculator.domain.strategy.CalculateStrategy;
import calculator.domain.strategy.MultiplicationStrategy;
import calculator.domain.strategy.SubtractionStrategy;

import java.util.List;
import java.util.Queue;

public class StringCalculator {

  private static final List<CalculateStrategy> calculateStrategies = List.of(
      new AdditionStrategy(),
      new SubtractionStrategy(),
      new MultiplicationStrategy()
  );

  private StringCalculator() {
  }

  public static int calculate(CalculatorQueue queue) {
    Queue<Operand> operandQueue = queue.getOperands();
    Queue<Operator> operatorQueue = queue.getOperators();
    int result = operandQueue.poll().toNumber();

    while (!operatorQueue.isEmpty()) {
      Operand secondOperand = operandQueue.poll();
      Operator operator = operatorQueue.poll();

      for (CalculateStrategy calculateStrategy : calculateStrategies) {
        result = calculateStrategy.calculate(result, operator, secondOperand.toNumber());
      }
    }

    return result;
  }
}
