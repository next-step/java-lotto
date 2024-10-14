package calculator.validator;

public class InputValidator {

  public static void validateInput(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException("입력값은 null이거나 공백일 수 없습니다.");
    }
  }
}
