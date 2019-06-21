package calculator;

public class StringCalculator {

  public static int splitAndSum(String input) {
    String[] strings = input.split(",");
    int result = 0;
    for (String num : strings) {
      result += Integer.valueOf(num.trim());
    }
    return result;
  }
}
