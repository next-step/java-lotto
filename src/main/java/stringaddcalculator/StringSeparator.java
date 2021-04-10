package stringaddcalculator;

import java.util.Arrays;
import java.util.List;

public class StringSeparator {

  private final List<String> separatorList;

  public StringSeparator(List<String> separatorList) {
    this.separatorList = separatorList;
  }

  public List<String> separateString(String value) {
    String[] split = value.split(this.generateSplitRegex());
    return Arrays.asList(split);
  }

  private String generateSplitRegex() {
    String splitRegex = String.join("\\", this.separatorList);
    return "[\\" + splitRegex + "]";
  }

}
