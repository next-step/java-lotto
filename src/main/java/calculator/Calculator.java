package calculator;

public class Calculator {

  public static void calculate(String input) {
    if (input == null) {
      throw new IllegalArgumentException("입력값은 null일 수 없습니다.");
    }
  }
}
