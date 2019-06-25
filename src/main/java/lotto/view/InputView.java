package lotto.view;

import java.util.Scanner;

public class InputView {

  public final static String QUESTION_PURCHASE_AMOUNT="구입금액을 입력해 주세요.";
  public final static String QUESTION_LAST_WEEK_LOTTO_NUMBER="지난 주 당첨 번호를 입력해 주세요.";
  static Scanner scanner = new Scanner(System.in);

  public static int askPurchaseAmount() {
    System.out.println(QUESTION_PURCHASE_AMOUNT);
    return scanner.nextInt();
  }

  public static String askLastWeekWinLottoNumber() {
    System.out.println(QUESTION_LAST_WEEK_LOTTO_NUMBER);
    return scanner.next();
  }

}
