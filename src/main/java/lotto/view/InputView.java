package lotto.view;

import java.util.Scanner;

public class InputView {

  private static final String INPUT_PURCHASED_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";

  private static final Scanner SCANNER = new Scanner(System.in);

  public static int inputPurchasedAmount() {
    System.out.println(INPUT_PURCHASED_AMOUNT_PROMPT);
    return SCANNER.nextInt();
  }
}
