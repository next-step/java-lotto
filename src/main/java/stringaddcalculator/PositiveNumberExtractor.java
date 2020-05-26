package stringaddcalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PositiveNumberExtractor {

  private final static String DEFAULT_SEPARATOR = "[,:]";

  public static List<PositiveNumber> create(String value) {
    if (Objects.isNull(value) || value.isEmpty()) {
      return Collections.singletonList(PositiveNumber.createForNullOrEmpty());
    }
    return Arrays.stream(value.split(DEFAULT_SEPARATOR))
        .map(PositiveNumber::create)
        .collect(Collectors.toList());
  }

  public static Integer sum(String value) {
    return Arrays.stream(value.split(DEFAULT_SEPARATOR))
        .map(PositiveNumber::create)
        .mapToInt(PositiveNumber::getNumber)
        .sum();
  }
}
