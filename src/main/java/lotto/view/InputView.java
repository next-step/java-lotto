package lotto.view;

import java.util.Scanner;

public class InputView {

  public final static String QUESTION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
  public final static String QUESTION_LAST_WEEK_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
  public final static String QUESTION_BONUS_BALL_NUMBER = "보너스 볼을 입력해 주세요.";
  public final static String QUESTION_MANUAL_LOTTO_BUY_QUANTITY = "수동으로 구매할 로또 수를 입력해 주세요.";
  public final static String QUESTION_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
  static Scanner scanner = new Scanner(System.in);

  public static int askPurchaseAmount() {
    System.out.println(QUESTION_PURCHASE_AMOUNT);
    return scanner.nextInt();
  }

  public static String askLastWeekWinLottoNumber() {
    System.out.println(QUESTION_LAST_WEEK_LOTTO_NUMBER);
    return scanner.next();
  }

  public static int askBonusBallNumber() {
    System.out.println(QUESTION_BONUS_BALL_NUMBER);
    return scanner.nextInt();
  }

  public static int askManualLottoBuyQuantity() {
    System.out.println(QUESTION_MANUAL_LOTTO_BUY_QUANTITY);
    return scanner.nextInt();
  }

  public static void askManualLottoNumbers() {
    System.out.println(QUESTION_MANUAL_LOTTO_NUMBERS);
  }

  public static String manualLottoNumberInput() {
    return scanner.next();
  }
}
