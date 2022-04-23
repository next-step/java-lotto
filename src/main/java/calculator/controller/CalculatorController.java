package calculator.controller;

import java.util.Arrays;
import java.util.List;

public class CalculatorController {

  private static final String DELIMITER = " ";

  public static void run(String input) {
    List<String> splited = split(input);
    // Numbers 생성
    // Operators 생성
    // Numbers, Operators를 인자로 받아 계산기 생성 후, 계산까지
  }

  private static List<String> split(String input) {
    validateInput(input);
    return Arrays.asList(input.split(DELIMITER));
  }

  private static void validateInput(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException("계산할 문자열을 입력해주세요.");
    }
  }
}
