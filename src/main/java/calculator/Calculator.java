package calculator;

import java.util.LinkedList;
import java.util.List;

public class Calculator {

  List<String> fourArithmetic;

  public Calculator() {
    fourArithmetic = new LinkedList<>();
    fourArithmetic.add("+");
    fourArithmetic.add("-");
    fourArithmetic.add("*");
    fourArithmetic.add("/");
  }

  public void validInput(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException();
    }

    String[] inputArray = input.split(" ");

    for (int i = 1; i < inputArray.length - 1; i += 2) {
      int number = validNumber(inputArray[i - 1]);
      String arithmeticMark = validArithmeticMark(inputArray[i]);
      int nextNumber = validNumber(inputArray[i + 1]);
    }

  }

  private int validNumber(String number) {
    return Integer.parseInt(number);
  }

  private String validArithmeticMark(String arithmeticMark) {
    if (!fourArithmetic.contains(arithmeticMark)) {
      throw new IllegalArgumentException();
    }
    return arithmeticMark;
  }
}
