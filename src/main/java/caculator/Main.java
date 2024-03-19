package caculator;

import caculator.domain.Number;

import java.util.Scanner;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    final String expression = readInput();

    Calculator calculator = new Calculator();
    displayResult(calculator.calculate(calculator.extractOperands(expression), calculator.extractOperators(expression)));
  }

  private static String readInput() {
    return scanner.nextLine();
  }

  private static void displayResult(Number result) {
    System.out.println("Answer: " + result);
  }
}
