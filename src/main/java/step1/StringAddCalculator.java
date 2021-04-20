package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import step1.data.Numbers;

public class StringAddCalculator {

  public static int splitAndSum(String str) {
    if(str == null || str.isEmpty()) {
      return 0;
    }

    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
    if (m.find()) {
      return new Numbers(split(m)).sum();
    }
    return new Numbers(split(str)).sum();
  }

  private static String[] split(String str) {
    return str.split(",|:");
  }

  private static String[] split(Matcher m) {
    String customDelimiter = m.group(1);
    return m.group(2).split(customDelimiter);
  }
}
