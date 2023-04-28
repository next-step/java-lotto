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
      String number = inputArray[i - 1];
      String arithmeticMark = inputArray[i];
      String nextNumber = inputArray[i + 1];

      validNumber(number);
      validArithmeticMark(arithmeticMark);
      validNumber(nextNumber);
    }

  }

  private void validNumber(String number) {
    Integer.parseInt(number);
  }

  private void validArithmeticMark(String arithmeticMark) {
    if (!fourArithmetic.contains(arithmeticMark)) {
      throw new IllegalArgumentException();
    }
  }
}
