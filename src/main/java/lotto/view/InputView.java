package lotto.view;

import java.util.Scanner;

public class InputView {

  public static int inputPriceOfBuy() {
    System.out.println("구입금액을 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }

  public static int inputManualBuy() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }

  public static String inputPrizeNumber() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return new Scanner(System.in).nextLine();
  }

  public static int inputBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }
}
