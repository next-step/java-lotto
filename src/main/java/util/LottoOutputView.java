package util;

import java.math.BigDecimal;
import lotto.Lotto;
import lotto.LottoList;
import lotto.LottoPrize;
import lotto.Result;
import lotto.WinningLotto;

public class LottoOutputView {

  private static final String MESSAGE_FOR_PRINTING_PURCHASE_AMOUNT =
      "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
  private static final String MESSAGE_FOR_PRINTING_RESULT = "총 수익률은 %s 입니다.";
  private static final String MESSAGE_FOR_INSERT_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
  private static final String MESSAGE_FOR_RESULT_INFO = "당첨 통계\n--------";
  private static final String MESSAGE_FOR_MATCHED_COUNT = "%s개 일치";
  private static final String MESSAGE_FOR_RESULT_DELIMITER = ", ";
  private static final String MESSAGE_FOR_BONUS_MATCHED = "보너스 볼 일치";
  private static final String MESSAGE_FOR_PRIZE = "(%s)";
  private static final String MESSAGE_FOR_MATCHED_LOTTO_COUNT = "- %s";
  private static final String LOTTO_BEGIN_MARK = "[";
  private static final String LOTTO_END_MARK = "]";


  private LottoOutputView() {
  }

  public static void printResult(LottoList lottoList, WinningLotto winningLotto) {
    printResultInfo();
    Result result = lottoList.drawing(winningLotto);
    int totalRevenue = 0;
    for (LottoPrize lottoPrize : LottoPrize.values()) {
      if (lottoPrize.equals(LottoPrize.NONE)) {
        continue;
      }
      int matchedLottoCount = result.getMatchedLottoCount(lottoPrize);
      totalRevenue += lottoPrize.getRevenue(matchedLottoCount);
      printResultMessage(result, lottoPrize);
    }

    printRevenueRate(lottoList.getRevenueRate(totalRevenue));
  }

  public static void printDescriptionForInsertManualLotto() {
    print(MESSAGE_FOR_INSERT_MANUAL_NUMBERS);
  }

  public static void printRevenueRate(BigDecimal revenueRate) {
    print(String.format(MESSAGE_FOR_PRINTING_RESULT, revenueRate));
  }

  public static void printManualPurchaseDone(int manualPurchaseAmount, int autoPurchaseAmount) {
    print(String.format(
        MESSAGE_FOR_PRINTING_PURCHASE_AMOUNT, manualPurchaseAmount, autoPurchaseAmount)
    );
  }

  public static void print(String text) {
    System.out.println(text);
  }

  public static void printLottoList(LottoList lottoList) {
    for (Lotto lotto : lottoList.getListOfLotto()) {
      print(LOTTO_BEGIN_MARK + lotto.toString() + LOTTO_END_MARK);
    }
  }

  public static void printResultInfo() {
    print(MESSAGE_FOR_RESULT_INFO);
  }

  private static void printResultMessage(Result result, LottoPrize lottoPrize) {
    String message = String.format(
        MESSAGE_FOR_MATCHED_COUNT, lottoPrize.getMatchedCount()
    );
    if (lottoPrize.hasBonus()) {
      message += MESSAGE_FOR_RESULT_DELIMITER + MESSAGE_FOR_BONUS_MATCHED;
    }
    message += String.format(MESSAGE_FOR_PRIZE, lottoPrize.getPrize());
    message += String.format(
        MESSAGE_FOR_MATCHED_LOTTO_COUNT, result.getMatchedLottoCount(lottoPrize)
    );
    print(message);
  }
}
