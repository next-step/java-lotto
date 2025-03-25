package lotto.view;

import java.util.Scanner;

public class InputView {
  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public int receiveMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    try {
      return scanner.nextInt();
    } catch (Exception e) {
      throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
    }
  }
}
