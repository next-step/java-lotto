package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InPutView {

  private static final Scanner scanner = new Scanner(System.in);

  public static int getAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    String amount = scanner.nextLine();
    return Integer.parseInt(amount);
  }

  public static String getResultLottoNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return scanner.nextLine();
  }

  public static Integer getBonusLottoNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    String manualCount = scanner.nextLine();
    return Integer.parseInt(manualCount);
  }

  public static Integer getManualCount() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    String manualCount = scanner.nextLine();
    return Integer.parseInt(manualCount);
  }

  public static List<String> getManualLottoNumbers(Integer manualCount) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    List<String> manualLottoNumbers = new ArrayList<>();
    for (int i = 0; i < manualCount; i++) {
      manualLottoNumbers.add(scanner.nextLine());
    }
    return manualLottoNumbers;
  }

}
