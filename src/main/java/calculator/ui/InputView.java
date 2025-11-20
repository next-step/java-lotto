package calculator.ui;

import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static String readExpression() {
    System.out.print("계산식을 입력하세요: ");
    return scanner.nextLine();
  }
}