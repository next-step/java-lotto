package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static int readPurchaseAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    return parseIntOrThrow(SCANNER.nextLine());
  }

  public static String readWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return SCANNER.nextLine();
  }

  public static String readBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return SCANNER.nextLine();
  }

  private static int parseIntOrThrow(String input) {
    try {
      return Integer.parseInt(input.trim());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자만 입력 가능합니다: " + input);
    }
  }

  public static int readManualLottoCount() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return parseIntOrThrow(SCANNER.nextLine());
  }

  public static List<String> readManualLottos(int count) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    List<String> input = new ArrayList<>();
    while (count-- > 0) {
      input.add(SCANNER.nextLine());
    }
    return input;
  }
}
