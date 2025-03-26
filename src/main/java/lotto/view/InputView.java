package lotto.view;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static int showPriceInput() {
    System.out.println("구입금액을 입력해 주세요.");
    int price = SCANNER.nextInt();
    SCANNER.nextLine();
    return price;
  }

  public static String showWinningNums() {
    System.out.printf("%n지난 주 당첨 번호를 입력해 주세요.%n");
    return SCANNER.nextLine();
  }

  public static int showBonusNumInput() {
    System.out.println("보너스 볼을 입력해 주세요.");
    int bonusNum = SCANNER.nextInt();
    SCANNER.nextLine();
    return bonusNum;
  }
}
