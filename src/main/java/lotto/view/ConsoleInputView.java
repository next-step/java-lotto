package lotto.view;

import java.util.Scanner;

public class ConsoleInputView {

  private Scanner scanner;

  public ConsoleInputView() {
    this.scanner = new Scanner(System.in);
  }

  public int inputPurchaseAmount() {

    System.out.println("구입금액을 입력해 주세요.");
    return this.scanner.nextInt();
  }

  public String inputWinNumbers() {

    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return this.scanner.next();
  }
}
