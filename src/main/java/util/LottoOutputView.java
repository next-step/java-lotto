package util;

import java.math.BigDecimal;

public class LottoOutputView {

  private static final String MESSAGE_FOR_PRINTING_PURCHASE_AMOUNT = "%s개를 구매했습니다.";
  private static final String MESSAGE_FOR_PRINTING_RESULT = "총 수익률은 %s 입니다.";
  private static final String MESSAGE_FOR_RESULT_INFO = "당첨 통계\n--------";


  private LottoOutputView() {
  }

  public static void printPurchaseAmount(int purchaseAmount) {
    print(buildPurchaseAmountMessage(purchaseAmount));
  }

  public static void printRevenueRate(BigDecimal revenueRate) {
    print(String.format(MESSAGE_FOR_PRINTING_RESULT, revenueRate));
  }

  public static void print(String text) {
    System.out.println(text);
  }

  public static void printResultInfo() {
    print(MESSAGE_FOR_RESULT_INFO);
  }

  private static String buildPurchaseAmountMessage(int purchaseAmount) {
    return String.format(MESSAGE_FOR_PRINTING_PURCHASE_AMOUNT, purchaseAmount);
  }
}
