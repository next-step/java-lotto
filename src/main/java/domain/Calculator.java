package domain;

public class Calculator {

  private final Numbers numbers;
  private final Operators operators;
  private final Operations operations;


  public Calculator(Numbers numbers, Operators operators) {
    this.numbers = numbers;
    this.operators = operators;
    this.operations = new Operations();
  }


  public int calculate() {
    int result = number();
    while (!isEmpty()) {
      result = calculation(result, number(), operator());
    }
    return result;
  }

  private boolean isEmpty() {
    return numbers.isEmpty();
  }

  private Integer number() {
    return numbers.poll();
  }

  private String operator() {
    return operators.poll();
  }

  private int calculation(int result, Integer number, String operator) {
    return operations.calculate(result, number, operator);
  }
}
