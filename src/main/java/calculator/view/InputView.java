package calculator.view;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  private InputView() {
  }

  public static void printRequest() {
    System.out.println("계산하려는 식을 입력해주세요.");
  }

  public static String getInput() {
    return SCANNER.nextLine();
  }
}
