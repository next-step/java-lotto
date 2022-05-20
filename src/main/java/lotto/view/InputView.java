package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static String amount() {
    System.out.println("구입금액을 입력해 주세요.");
    return scanner.nextLine();
  }

  public static String winLottoNumber() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return scanner.nextLine();
  }

  public static String bonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return scanner.nextLine();
  }

  public static String numberOfManual() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return scanner.nextLine();
  }

  public static List<String> manualLottoNumbers(int numberOfManual) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    List<String> manualLottoNumbers = new ArrayList<>();
    for (int i = 0; i < numberOfManual; i++) {
      manualLottoNumbers.add(scanner.nextLine());
    }
    return manualLottoNumbers;
  }

}
