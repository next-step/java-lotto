package step1;

public class StringAddCalculator {
  public static int splitAndSum(String expression) {
    Calculator calc = new Calculator(Splitter.split(expression));
    return calc.sum();
  }
}
