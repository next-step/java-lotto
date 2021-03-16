package calculator;

public class StringAddCalculator {

  public int splitAndSum(String input) {
    if (InputValidator.isEmptyOrBlank(input)) {
      return 0;
    }

    if (InputValidator.isSingleNumber(input)) {
      return Integer.parseInt(input);
    }

    return calculate(input);
  }


  public int calculate(String input) {
    String[] numbers = input.split(",");
    int result = 0;

    for (int i = 0; i < numbers.length; i++) {
      InputValidator.validateNumber(numbers[i]);
      result += Integer.parseInt(numbers[i]);
    }

    return result;
  }

}
