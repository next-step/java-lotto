package calculator.domain;

import java.util.Queue;

public class StringCalculator {

  private StringCalculator() {
  }

  public static int calculate(CalculatorQueue queue) {
    Queue<Operand> operandQueue = queue.getOperands();
    Queue<Operator> operatorQueue = queue.getOperators();

    int result = operandQueue.poll().toNumber();
    while (!operatorQueue.isEmpty()) {
      Operator operator = operatorQueue.poll();
      Operand operand = operandQueue.poll();
      result = operator.apply(result, operand.toNumber());
    }

    return result;
  }
}
