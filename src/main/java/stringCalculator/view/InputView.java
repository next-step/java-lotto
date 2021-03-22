package stringCalculator.view;

import java.util.Scanner;

public class InputView {

  private static final String NUMBER_INPUT = "숫자를 입력해주세요.";
  private final Scanner scanner = new Scanner(System.in);

  public String input() {
    System.out.println(NUMBER_INPUT);
    return scanner.next();
  }

}
