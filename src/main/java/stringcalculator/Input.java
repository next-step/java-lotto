package stringcalculator;

public class Input {

  private String input;

  public Input(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    this.input = input;
  }

  public String[] inputSplit() {
    return StringSpliter.split(this.input);
  }
}
