package calculator.utils;

import java.util.Scanner;

public class InputView {
  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public String receiveUserInput() {
    System.out.println("계산할 식을 입력하세요.");
    return scanner.nextLine().trim();
  }
}
