package stringCalculator.domain;

import java.util.Objects;

public class StringValue {

  private String stringValue;

  public static final String DEFAULT_VALUE = "0";

  public StringValue(String stringValue) {
    this.stringValue = validationText(stringValue);
  }

  public String getStringValue() {
    return stringValue;
  }

  private String validationText(String text) {
    if(text == null || text.isEmpty()){
      return DEFAULT_VALUE;
    }

    return text;
  }

  public String[] getSplit(String mark) {
    return getStringValue().split(mark);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StringValue that = (StringValue) o;
    return Objects.equals(getStringValue(), that.getStringValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getStringValue());
  }
}