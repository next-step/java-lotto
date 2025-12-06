package lotto.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import lotto.InputRetry;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static int readPurchaseAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    return readInt();
  }

  public static int readManualLottoCount() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return readInt();
  }

  public static List<String> readManualLottos(int count) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    List<String> input = new ArrayList<>();
    while (count-- > 0) {
      input.add(SCANNER.nextLine().trim());
    }
    System.out.println();
    return input;
  }

  public static String readWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return SCANNER.nextLine();
  }

  public static int readBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return readInt();
  }

  private static int readInt() {
    return InputRetry.retry(() -> {
      try {
        int value = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println();
        return value;
      } catch (InputMismatchException e) {
        SCANNER.nextLine();
        throw new IllegalArgumentException("숫자를 올바르게 입력하세요.");
      }
    });
  }

}
