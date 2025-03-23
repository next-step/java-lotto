package calculator.operator;

public class OperationFactory {
  public static Operator getOperator(String input) {
    switch (input) {
      case "+":
        return new AddOperator();
      case "-":
        return new SubtractOperator();
      case "/":
        return new DivideOperator();
       case "*":
           return new MultiplyOperator();
      default:
        throw new IllegalArgumentException("Invalid operator: " + input);
    }
  }
}
