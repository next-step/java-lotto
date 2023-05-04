package study.stringcalculator.domain;

public class InputValue {

  private String inputValue;

  public InputValue(final String inputValue) {
    isNullOrBlank(inputValue);

    this.inputValue = inputValue.trim();
  }

  public String[] split() {
    String[] splitArr = inputValue.split(" ");

    for (String split : splitArr) {
      isNullOrBlank(split);
    }
    return splitArr;
  }

  private void isNullOrBlank(String inputValue) {
    if (inputValue == null || inputValue.isBlank()) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }
  }
}
