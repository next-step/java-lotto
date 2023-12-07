package lotto.view;

import java.util.Scanner;

public class InPutView {

  private static final Scanner scanner = new Scanner(System.in);

  public static int getAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    return scanner.nextInt();
  }

  public static String getResultLottoNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    scanner.nextLine();
    return scanner.nextLine();
  }

  public static Integer getBonusLottoNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return scanner.nextInt();
  }

}
