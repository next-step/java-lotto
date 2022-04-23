package calculator.controller;

import calculator.domain.Numbers;
import calculator.domain.Operations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorController {

  private static final String DELIMITER = " ";

  public static void run(String input) {
    List<String> splited = split(input);
    Numbers numbers = Numbers.of(getValuesOfEvenIndex(splited));
    Operations operations = Operations.of(getValuesOfOddIndex(splited));
    // Numbers 생성
    // Operators 생성
    // Numbers, Operators를 인자로 받아 계산기 생성 후, 계산까지
  }

  private static List<String> split(String input) {
    validateInput(input);

    List<String> splited = Arrays.asList(input.split(DELIMITER));
    validateSplitedSize(splited);
    return splited;
  }

  private static List<String> getValuesOfEvenIndex(List<String> splited) {
    return exractValues(splited, 0);
  }

  private static List<String> getValuesOfOddIndex(List<String> splited) {
    return exractValues(splited, 1);
  }

  private static List<String> exractValues(List<String> splited, int startIndex) {
    List<String> candidates = new ArrayList<>();
    for (int i = startIndex; i < splited.size(); i += 2) {
      candidates.add(splited.get(i));
    }
    return candidates;
  }

  private static void validateInput(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException("계산할 문자열을 입력해주세요.");
    }
  }

  private static void validateSplitedSize(List<String> splited) {
    if (splited.size() % 2 == 0) {
      throw new IllegalArgumentException("올바른 문자열을 입력해주세요.");
    }
  }
}
