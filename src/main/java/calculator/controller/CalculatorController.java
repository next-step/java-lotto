package calculator.controller;

import calculator.domain.CalculatorQueue;
import calculator.domain.StringCalculator;

import java.util.List;

public class CalculatorController {

  private static final List<String> INPUTS = List.of(
      "2 + 3 * 4 / 2",
      "5 * 60 / 10 + 10 - 15"
  );

  public static void main(String[] args) {
    INPUTS.forEach(input -> {
      CalculatorQueue calculatorQueue = CalculatorQueue.of(input);
      int result = StringCalculator.calculate(calculatorQueue);
      printResult(input, result);
    });
  }

  private static void printResult(String input, int result) {
    System.out.println("input: " + input + ", result: " + result);
  }
}
