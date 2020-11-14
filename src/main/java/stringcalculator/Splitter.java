package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

  private static final String[] DEFAULT_DELIMITERS = {":", ","};
  private static final String EXTRA_DELIMITER_PATTERN = "//(.)\n(.*)";

  private final List<String> delimiters;

  public Splitter() {
    delimiters = new Vector<>(Arrays.asList(DEFAULT_DELIMITERS));
  }

  public String[] splitInput(String input) {
    String expression = extractExpressionPart(input);
    return expression.split(makeSplitPatternRegex());
  }

  private String extractExpressionPart(String input) {
    Matcher matcher = Pattern.compile(EXTRA_DELIMITER_PATTERN).matcher(input);
    if (existsExtraDelimiter(matcher)) {
      addDelimiter(matcher.group(1));
      return matcher.group(2);
    }
    return input;
  }

  private boolean existsExtraDelimiter(Matcher matcher) {
    return matcher.find();
  }

  private void addDelimiter(String delimiter) {
    this.delimiters.add(delimiter);
  }

  private String makeSplitPatternRegex() {
    StringBuilder pattern = new StringBuilder();
    pattern.append("[");
    for (String delimiter : this.delimiters) {
      pattern.append(delimiter);
    }
    pattern.append("]");
    return pattern.toString();
  }
}
