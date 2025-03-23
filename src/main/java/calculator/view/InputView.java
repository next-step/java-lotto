package calculator.view;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static String showExpressionInput() {
    System.out.println("연산식을 입력하세요.");
    return SCANNER.nextLine();
  }
}
