package util;

import static util.Validator.validateArgument;

import java.util.Scanner;

public class LottoInputView {

  private static final String MESSAGE_FOR_INSERT_PAYMENT_AMOUNT = "구입 금액을 입력해주세요.";
  private static final String MESSAGE_FOR_INVALID_PAYMENT_AMOUNT = "구입 금액은 최소 %s 이상이어야 합니다.";
  private static final String MESSAGE_FOR_INSERT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
  private static final Scanner SCANNER = new Scanner(System.in);
  private static final int LOTTO_PRICE = 1000;


  private LottoInputView() {
  }

  public static Integer scanInt(String description) {
    printDescription(description);
    return Integer.parseInt(SCANNER.nextLine());
  }

  public static String scanString(String description) {
    printDescription(description);
    return SCANNER.nextLine();
  }

  public static int insertPaymentAmount() {
    int paymentAmount = scanInt(MESSAGE_FOR_INSERT_PAYMENT_AMOUNT);
    validatePaymentAmount(paymentAmount);
    return paymentAmount;
  }

  public static String insertWinningLotto() {
    return scanString(MESSAGE_FOR_INSERT_WINNING_NUMBERS);
  }

  private static void printDescription(String description) {
    System.out.println(description);
  }

  private static void validatePaymentAmount(int paymentAmount) {
    validateArgument(
        paymentAmount,
        (arg) -> paymentAmount >= LOTTO_PRICE,
        buildInvalidPaymentAmountMessage(paymentAmount)
    );
  }

  private static String buildInvalidPaymentAmountMessage(int purchaseAmount) {
    return String.format(MESSAGE_FOR_INVALID_PAYMENT_AMOUNT, LOTTO_PRICE);
  }
}
