package lotto2.view;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final int TICKET_PRICE = 1000;

  public static int scanMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    String investMoney = SCANNER.nextLine();
    validateMoney(investMoney);
    return Integer.parseInt(investMoney);
  }

  private static void validateMoney(String investMoney) {
    if (investMoney == null || investMoney.isBlank()) {
      throw new IllegalArgumentException("구입금액을 입력해 주세요.");
    }
    if (!investMoney.matches("^[0-9]*$")) {
      throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
    }
    if (Integer.parseInt(investMoney) % TICKET_PRICE != 0) {
      throw new IllegalArgumentException("구입금액은 1000원 단위로 입력 가능합니다.");
    }
  }
}
