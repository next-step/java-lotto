package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AwardNumberUtil {

  private static final String DELIMITER = ", ";

  private static String[] split(String str) {
    return str.split(DELIMITER);
  }

  public static List<Integer> getAwadNumberList(String str) {
    return Arrays.stream(split(str)).map(Integer::parseInt).collect(Collectors.toList());
  }


}
