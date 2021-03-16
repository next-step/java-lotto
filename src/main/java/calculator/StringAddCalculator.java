package calculator;

public class StringAddCalculator {

  public int splitAndSum(String input) {
    if (InputValidator.isEmptyOrBlank(input)) {
      return 0;
    }

    if (InputValidator.isSingleNumber(input)) {
      return Integer.parseInt(input);
    }

    return 1;
  }
}
