package calculator;

public class StringAddCalculator {

  private Numbers numbers;

  public int splitAndSum(String input) {
    if (InputValidator.isEmptyOrBlank(input)) {
      return 0;
    }
    numbers = new Numbers(input);
    return numbers.sumOfNumbers();
  }
}
