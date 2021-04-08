package calculator.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class StringUtil {

  private StringUtil() {
  }

  public static boolean isBlank(String str) {
    return str == null || str.isEmpty() || str.trim().isEmpty();
  }

  public static String defaultBlankString(String str) {
    return defaultBlankString(str, "");
  }

  public static String defaultBlankString(String str, String defaultStr) {
    if (isBlank(str)) {
      return defaultStr;
    }
    return str;
  }

  public static boolean find(String str, String regex) {
    return getMatcher(str, regex).find();
  }

  public static String findGroup(String str, String regex, int group) {
    if (find(str, regex)) {
      Matcher matcher = getMatcher(str, regex);
      matcher.matches();
      return matcher.group(group);
    }
    return "";
  }

  private static Matcher getMatcher(String str, String regex) {
    Matcher matcher = Pattern.compile(regex).matcher(str);
    return matcher;
  }

  public static List<String> splitToList(String str) {
    return Arrays.stream(defaultBlankString(str).split(","))
            .collect(Collectors.toList());
  }

  public static String trim(String str) {
    return defaultBlankString(str).trim();
  }

  public static String convertMoneyFormatting(long money) {
    DecimalFormat decimalFormat = new DecimalFormat("###,###");
    return decimalFormat.format(money);
  }
}