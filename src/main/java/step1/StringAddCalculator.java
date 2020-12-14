package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
  public static int splitAndSum(String input) {
    if (isEmpty(input)) {
      return 0;
    }
    String[] numbers = split(input);
    return getSum(numbers);
  }

  private static int getSum(String[] numbers) {
    int sum = 0;
    for(String number: numbers) {
      int intNumber = Integer.parseInt(number);
      negativeCheck(intNumber);
      sum +=intNumber;
    }
    return sum;
  }

  private static String[] split(String input) {
    String[] numbers = input.split(",|:");
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
    if (m.find()) {
      String customDelimiter = m.group(1);
      numbers = m.group(2).split(customDelimiter);
    }
    return numbers;
  }

  private static void negativeCheck(int number) {
    if (number < 0) {
      throw new IllegalArgumentException();
    }
  }

  private static boolean isEmpty(String input) {
    return input == null || "".equals(input);
  }
}
