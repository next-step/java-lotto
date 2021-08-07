package lotto.service;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import lotto.message.Message;

public enum Operation {
  PLUS("+", (number1, number2)-> number1 + number2),
  MINUS("-", (number1, number2)-> number1 - number2),
  MULTIPLE("*", (number1, number2) -> number1 * number2),
  DIVISION_SHARE("/", (number1, number2) -> {
    isWrongNumber(number1, number2);
    return number1 / number2;
  }),
  DIVISION_REMAINDER("%", (number1, number2)->{
    isWrongNumber(number1, number2);
    return number1 % number2;
  });

  private static void isWrongNumber(final int number1, final int number2) {
    if (number1 == 0 || number2 == 0) {
      throw new ArithmeticException();
    }
  }

  private final String operationMark;

  private final IntBinaryOperator intBinaryOperator;

  Operation(String operationMark, IntBinaryOperator intBinaryOperator) {
    this.operationMark = operationMark;
    this.intBinaryOperator = intBinaryOperator;
  }

  public int calculation(int num1, int num2){
    return intBinaryOperator.applyAsInt(num1, num2);
  }

  public String getOperation() {
    return operationMark;
  }

  public static Operation chooseOperation(Operation operation){
    return Arrays.stream(Operation.values())
        .filter(v -> v.equals(operation))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException(Message.MSG_ERROR_MISS_MATCH_OPERATION));
  }
}
