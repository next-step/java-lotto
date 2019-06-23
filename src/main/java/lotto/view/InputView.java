package lotto.view;

public class InputView {

  public final static String QUESTION_PURCHASE_AMOUNT="구입금액을 입력해 주세요.";
  public final static String QUESTION_LAST_WEEK_LOTTO_NUMBER="지난 주 당첨 번호를 입력해 주세요.";

  public static void askPurchaseAmount() {
    System.out.println(QUESTION_PURCHASE_AMOUNT);
  }

  public static void askLastWeekWinLottoNumber() {
    System.out.println(QUESTION_LAST_WEEK_LOTTO_NUMBER);
  }


}
