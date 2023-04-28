package view;

import domain.Numbers;
import domain.Operators;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class InputView {

  private static final String INPUT_MESSAGE = "계산할 식을 입력하세요.";
  private static final String INPUT_DELIMITER = " ";
  private static final Scanner scanner = new Scanner(System.in);

  public static String[] scanInput() {
    System.out.println(INPUT_MESSAGE);
    String inputString = scanner.nextLine();
    InputValidation.validateInput(inputString);
    return inputString.split(INPUT_DELIMITER);
  }

  public static Numbers number(String[] input) {
    List<String> numbers = new LinkedList<>();
    for (int i = 0; i < input.length; i += 2) {
      numbers.add(input[i]);
    }
    return new Numbers(numbers);
  }

  public static Operators operator(String[] input) {
    Queue<String> operators = new LinkedList<>();
    for (int i = 1; i < input.length; i += 2) {
      operators.add(input[i]);
    }
    return new Operators(operators);
  }
}
