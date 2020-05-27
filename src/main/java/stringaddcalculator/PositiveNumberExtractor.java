package stringaddcalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PositiveNumberExtractor {

  private final static String DEFAULT_SEPARATOR = "[,:]";
  private final static String CUSTOM_SEPARATOR_PATTERN = "//(.)\n(.*)";

  public static List<PositiveNumber> create(String value) {
    if (Objects.isNull(value) || value.isEmpty()) {
      return Collections.singletonList(PositiveNumber.createForNullOrEmpty());
    }
    if (returnMatcher(DEFAULT_SEPARATOR, value).find()) {
      return createByDefaultSeparator(value);
    }
    if (returnMatcher(CUSTOM_SEPARATOR_PATTERN, value).matches()) {
      return createByCustomSeparator(value);
    }
    return Collections.singletonList(PositiveNumber.create(value));
  }

  public static List<PositiveNumber> createByDefaultSeparator(String value) {
    return Arrays.stream(value.split(DEFAULT_SEPARATOR))
        .map(PositiveNumber::create)
        .collect(Collectors.toList());
  }

  public static List<PositiveNumber> createByCustomSeparator(String value) {
    Matcher m = Pattern.compile(CUSTOM_SEPARATOR_PATTERN).matcher(value);
    if (m.find()) {
      String customDelimiter = m.group(1);
      String[] tokens = m.group(2).split(customDelimiter);
      return Arrays.stream(tokens)
          .map(PositiveNumber::create)
          .collect(Collectors.toList());
    }
    throw new RuntimeException("something is wrong.");
  }

  public static Matcher returnMatcher(String separator, String value) {
    return Pattern.compile(separator).matcher(value);
  }
}
