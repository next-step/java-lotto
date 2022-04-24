package lotto.view;

import java.util.Scanner;

public class InputView {

  private static Scanner SCANNER = new Scanner(System.in);

  private InputView() {
  }

  public static int getPurchaseAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    return getIntInput();
  }

  public static String getLastWeekWinningNumber() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return getStringInput();
  }

  private static int getIntInput() {
    return SCANNER.nextInt();
  }

  private static String getStringInput() {
    return SCANNER.nextLine();
  }
}
