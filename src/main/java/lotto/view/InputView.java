package lotto.view;

import java.util.Scanner;
import lotto.domain.Lotto;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  public static int inputCost() {
    System.out.println("구입금액을 입력해 주세요.");
    int cost = scanner.nextInt();
    scanner.nextLine();
    return cost;
  }

  public static Lotto inputWinningLotto() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String input = scanner.nextLine();
    return Lotto.of(input);
  }

  public static void closeScanner() {
    scanner.close();
  }

}
