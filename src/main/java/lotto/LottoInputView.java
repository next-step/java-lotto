package lotto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoInputView {

  private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String NOT_A_NUMBER_INPUT_ERROR_MESSAGE = "숫자로 제대로 입력해주세요.";

  public static int askPurchaseAmount() {
    System.out.println(PURCHASE_AMOUNT_MESSAGE);

    try {
      Scanner scanner = new Scanner(System.in);
      int purchaseAmount = scanner.nextInt();
      return purchaseAmount;
    } catch(InputMismatchException e) {
      throw new IllegalArgumentException(NOT_A_NUMBER_INPUT_ERROR_MESSAGE);
    }
  }
}
