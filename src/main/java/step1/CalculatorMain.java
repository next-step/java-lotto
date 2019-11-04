package step1;

import java.util.Scanner;

public class CalculatorMain {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String inputValue = scanner.nextLine();
    StringAddCalculator stringAddCalculator = new StringAddCalculator(inputValue);
    int result = stringAddCalculator.calculate();
    System.out.println(result);
  }
}
