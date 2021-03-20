package calculator;

import calculator.domain.Formula;

public class Calculator {
  public static void main(String[] args) {
    Formula formula = Formula.createFormula("1:2:3");
    System.out.println(formula.summation());
  }
}
