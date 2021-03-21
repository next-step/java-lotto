package calculator;

import calculator.domain.Formula;

public class StringAddCalculator {

  public static void main(String[] args) {
    System.out.println(splitAndSum("1,2:3"));
  }

  public static int splitAndSum(String userInput) {
    Formula calculator = Formula.createFormula(userInput);
    return calculator.summation();
  }
}
