package step1.controller;

import step1.service.Calculator;
import step1.Splitter;

public class StringAddCalculator {
  public static int splitAndSum(String expression) {
    Calculator calc = new Calculator(Splitter.split(expression));
    return calc.sum();
  }
}
