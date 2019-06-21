package calculator;

public class StringCalculator {

  public static int splitAndSum(String input) {
    String[] numbers = input.split("[,:]");
    int result = 0;
    for (String number : numbers) {
      result += Integer.valueOf(number.trim());
    }
    return result;
  }
}
