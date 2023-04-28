package view;

public class InputValidation {

  public static void validateInput(String inputString) {
    if (inputString == null || inputString.isEmpty()) {
      throw new IllegalArgumentException("입력 값이 없습니다.");
    }
  }
}
