package caculator;

public class Main {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    final String expression = calculator.readInput();
    System.out.println("Answer: " + calculator.calculate(calculator.extractOperands(expression), calculator.extractOperators(expression)));
  }
}
