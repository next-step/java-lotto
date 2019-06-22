package lotto;

import java.util.Scanner;

public class LottoInputView {

  private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

  public static int askPurchaseAmount() {
    System.out.println(PURCHASE_AMOUNT_MESSAGE);

    Scanner scanner = new Scanner(System.in);
    int purchaseAmount = scanner.nextInt();

    return purchaseAmount;
  }
}
