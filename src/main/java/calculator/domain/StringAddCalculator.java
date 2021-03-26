package calculator.domain;

public class StringAddCalculator {
  public static int splitAndSum(String userInput) {
    Formula calculator = Formula.createFormula(userInput);
    return calculator.summation();
  }
}
