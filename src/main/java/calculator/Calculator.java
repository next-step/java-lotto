package calculator;

public class Calculator {

  public void validInput(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException();
    }
  }
}
