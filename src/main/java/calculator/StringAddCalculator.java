package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static String userInput;

  public static int splitAndSum(String userInput) {
    StringAddCalculator.userInput = userInput;

    return getSummationResult();
  }

  private static int getSummationResult() {
    if(isNullOrEmptyString(userInput)) {
      return 0;
    }

    if(isContainCommaOrColon(userInput)) {
      List<String> split = Arrays.asList(userInput.split("[,:]"));
      return summation(split);
    }

    if(isCustomSeparator(userInput)) {
      return customSeparatorSummation(userInput);
    }

    if(isNumeric(userInput)) {
      return Integer.parseInt(userInput);
    }

    throw new IllegalArgumentException("잘못 된 값이 입력되었습니다.");
  }

  private static boolean isNumeric(String userInput) {
    return userInput.matches("-?\\d+(\\.\\d+)?");
  }


  private static int summation(List<String> split) {
    if(isNegativeNumber(split))
      throw new IllegalArgumentException("음수는 입력하실 수 없습니다.");

    return split.stream().mapToInt(Integer::parseInt).sum();
  }

  private static boolean isNegativeNumber(List<String> split) {
    long negativeNumberCount = split.stream()
        .filter(i -> Integer.parseInt(i) < 0)
        .count();

    return negativeNumberCount > 0;
  }

  private static int customSeparatorSummation(String userInput) {
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(userInput);

    m.find();

    String customDelimiter = m.group(1);
    String[] tokens = m.group(2).split(customDelimiter);

    return summation(Arrays.asList(tokens));
  }

  private static boolean isCustomSeparator(String userInput) {
    return Pattern.compile("//(.)\n(.*)").matcher(userInput).find();
  }

  private static boolean isContainCommaOrColon(String userInput) {
    return userInput.contains(":") || userInput.contains(",");
  }

  private static boolean isNullOrEmptyString(String userInput) {
    return userInput == null || userInput.equals("");
  }
}
