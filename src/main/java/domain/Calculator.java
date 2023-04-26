package domain;

public class Calculator {

  private final Numbers numbers;
  private final Operators operators;


  public Calculator(Numbers numbers, Operators operators) {
    this.numbers = numbers;
    this.operators = operators;
  }


  public int calculate() {
    int result = 0;
    while (!operators.isEmpty()) {
      result = Operations.calculate(numbers.nextValue(), numbers.nextValue(), operators.nextOperator());
    }
    return result;
  }
}
