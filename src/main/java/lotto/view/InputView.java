package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Amount;
import lotto.util.InputValidator;

public class InputView {

  public static int inputPriceOfBuy() {
    System.out.println("구입금액을 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }

  public static int inputManualBuy() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }

  public static List<String> inputManualNumbers(Amount amount) {
    List<String> manualNumbers = new ArrayList<>();
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");

    for (int i = 0; i < amount.getManualAmount(); i++) {
      manualNumbers.add(value());
    }
    return manualNumbers;
  }

  private static String value() {
    String input = new Scanner(System.in).nextLine();
    if (InputValidator.isEmptyOrBlank(input)) {
      throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
    }
    return input;
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
