package lotto.service;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import lotto.message.Message;

public enum Operation {
  PLUS("+", (a, b)-> {
    return a + b;
  }),
  MINUS("-", (a, b)-> {
    return a - b;
  }),
  MULTIPLE("*", (a, b) -> {
    return a * b;
  }),
  DIVISION_SHARE("/", (a, b) -> {
    if(a == 0 || b ==0){
      throw new ArithmeticException();
    }
    return a / b;
  }),
  DIVISION_REMAINDER("%", (a, b)->{
    if(a == 0 || b ==0){
      throw new ArithmeticException();
    }
    return a % b;
  });

  private final String operationMark;

  private final IntBinaryOperator intBinaryOperator;

  Operation(String operationMark, IntBinaryOperator intBinaryOperator) {
    this.operationMark = operationMark;
    this.intBinaryOperator = intBinaryOperator;
  }

  protected int calculation(int num1, int num2){
    return intBinaryOperator.applyAsInt(num1, num2);
  }

  public String getOperation() {
    return operationMark;
  }

  public static Operation chooseOperation(String operation){
    return Arrays.stream(Operation.values())
        .filter(v -> v.getOperation().equals(operation))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException(Message.MSG_ERROR_MISS_MATCH_OPERATION));
  }
}
