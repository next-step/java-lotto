package lotto.io;

import java.util.Scanner;
import lotto.domain.Lotto;

public final class InputView {

  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public int inputMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    return Integer.parseInt(scanner.nextLine());
  }

  public Lotto inputLastWinningNumber() {
    System.out.println("지난 주 당첨 번호를 입력해주세요.");
    String winningNumberString = scanner.nextLine();
    String[] winningNumbers = winningNumberString.split(", ");
    System.out.println();
    return new Lotto(winningNumbers);
  }
}
