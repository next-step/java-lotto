package step1.controller;

import step1.Splitter;
import step1.service.Calculator;

public class StringAddCalculator {
  public static int splitAndSum(String expression) {
    Calculator calc = new Calculator(Splitter.split(expression));
    return calc.sum();
  }
}
