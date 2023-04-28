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

    if (fourArithmetic.contains(inputArray[0]) || fourArithmetic.contains(inputArray[inputArray.length - 1])) {
      throw new IllegalArgumentException();
    }

  }
}
