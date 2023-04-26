package domain;

public class Calculator {

  private final Numbers numbers;
  private final Operators operators;


  public Calculator(Numbers numbers, Operators operators) {
    this.numbers = numbers;
    this.operators = operators;
  }


  public int calculate() {
    int result = numbers.nextValue();
    while (!operators.isEmpty()) {
      result = Operations.calculate(result, numbers.nextValue(), operators.nextOperator());
    }
    return result;
  }
}
