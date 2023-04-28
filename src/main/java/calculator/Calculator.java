package calculator;

import java.util.LinkedList;
import java.util.List;

public class Calculator {

  private static final String ADDITION = "+";
  private static final String SUBTRACTION = "-";
  private static final String MULTIPLICATION = "*";
  private static final String DIVISION = "/";

  List<String> fourArithmetic;

  public Calculator() {
    fourArithmetic = new LinkedList<>();
    fourArithmetic.add(ADDITION);
    fourArithmetic.add(SUBTRACTION);
    fourArithmetic.add(MULTIPLICATION);
    fourArithmetic.add(DIVISION);
  }

  public String validInput(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException();
    }
    return input;
  }

  public int calculation(String input) {
    String[] inputArray = split(validInput(input));

    int number = validNumber(inputArray[0]);
    for (int i = 1; i < inputArray.length - 1; i += 2) {
      String arithmeticMark = validArithmeticMark(inputArray[i]);
      int nextNumber = validNumber(inputArray[i + 1]);
      number = calculation(number, arithmeticMark, nextNumber);
    }

    return number;
  }

  private int calculation(int number, String arithmeticMark, int nextNumber) {
    if (arithmeticMark.equals(ADDITION)) {
      return number + nextNumber;
    }

    if (arithmeticMark.equals(SUBTRACTION)) {
      return number - nextNumber;
    }

    if (arithmeticMark.equals(MULTIPLICATION)) {
      return number * nextNumber;
    }

    if (arithmeticMark.equals(DIVISION)) {
      checkRemainderIsZero(number % nextNumber);
      return number / nextNumber;
    }

    throw new IllegalArgumentException();
  }

  private void checkRemainderIsZero(int remainder) {
    if (remainder != 0) {
      throw new IllegalArgumentException();
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

  private String[] split(String input) {
    return input.split(" ");
  }
}
