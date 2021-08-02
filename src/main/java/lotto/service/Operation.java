package lotto.service;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operation {
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
        .orElseThrow(() -> new IllegalArgumentException("일치하는 연산자가 없습니다."));
  }
}
