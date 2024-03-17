package calculator.domain;

import calculator.domain.strategy.*;

import java.util.List;
import java.util.Queue;

public class StringCalculator {

  private static final List<CalculateStrategy> calculateStrategies = List.of(
      new AdditionStrategy(),
      new SubtractionStrategy(),
      new MultiplicationStrategy(),
      new DivisionStrategy()
  );

  private StringCalculator() {
  }

  public static int calculate(CalculatorQueue queue) {
    Queue<Operand> operandQueue = queue.getOperands();
    Queue<Operator> operatorQueue = queue.getOperators();

    int result = operandQueue.poll().toNumber();
    while (!operatorQueue.isEmpty()) {
      result = doCalculateStrategies(result, operandQueue.poll(), operatorQueue.poll());
    }

    return result;
  }

  private static int doCalculateStrategies(int result, Operand secondOperand, Operator operator) {
    for (CalculateStrategy calculateStrategy : calculateStrategies) {
      result = calculateStrategy.calculate(result, operator, secondOperand.toNumber());
    }
    return result;
  }
}
