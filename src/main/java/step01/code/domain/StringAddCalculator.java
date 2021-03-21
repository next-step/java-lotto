package step01.code.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.platform.commons.util.StringUtils;

public class StringAddCalculator {

  public static int splitAndSum(String str) {
    // return new Number(str).number();
    if(StringUtils.isBlank(str)) {
      return 0;
    }
    return sum(split(str));
  }

  public static List<Number> split(String str) {
    return Arrays.asList(str.split(",|:"))
      .stream()
      .map((num) -> new Number(num))
      .collect(Collectors.toList()); 
  }

  public static int sum(List<Number> numbers) {
    return numbers.stream()
      .map((num) -> num.number())
      .reduce((x, y) -> x + y)
      .orElseThrow(() -> new IllegalArgumentException("숫자들의 합은 int 값이어야 합니다."));
  }
  
}
