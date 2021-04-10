package stringaddcalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class StringSeparator {

  private final Set<String> separatorList;

  public StringSeparator(Set<String> separatorList) {
    this.separatorList = separatorList;
  }

  public StringSeparator(String separator) {
    this.separatorList = Collections.singleton(separator);
  }

  public List<String> separateString(String value) {
    String[] split = value.split(this.generateSplitRegex());
    return Arrays.asList(split);
  }

  private String generateSplitRegex() {
    String splitRegex = String.join("", this.separatorList);
    return "[" + splitRegex + "]";
  }

}
