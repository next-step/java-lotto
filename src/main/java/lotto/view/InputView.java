package lotto.view;

import lotto.PurchaseAmount;
import java.util.Scanner;

public class InputView {
  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public PurchaseAmount receiveMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    try {
      int money = Integer.parseInt(scanner.nextLine().trim());
      return new PurchaseAmount(money);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
    }
  }

  public String receiveWinningLotto() {
    System.out.println("지난 주 당첨 번호를 입력해주세요.");
    return scanner.nextLine();
  }
}
