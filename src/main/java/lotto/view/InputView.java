package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static int showPriceInput() {
    System.out.println("구입금액을 입력해 주세요.");
    int price = SCANNER.nextInt();
    SCANNER.nextLine();
    return price;
  }

  public static int showManualPurchaseCount() {
    System.out.printf("%n수동으로 구매할 로또 수를 입력해 주세요.%n");
    int price = SCANNER.nextInt();
    SCANNER.nextLine();
    return price;
  }

  public static List<String> showManualLottoNumbersBundle(int count) {
    System.out.printf("%n수동으로 구매할 번호를 입력해 주세요.%n");
    List<String> res = new ArrayList<>();
    IntStream.range(0, count)
        .forEach(i -> res.add(SCANNER.nextLine()));

    return res;
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
