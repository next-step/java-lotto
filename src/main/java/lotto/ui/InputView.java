package lotto.ui;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final String REQUEST_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
  private static final String REQUEST_MANUAL_PURCHASE_LOTTO = "수동으로 구매할 로또 수를 입력해 주세요.";
  private static final String REQUEST_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
  private static final String REQUEST_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String REQUEST_BONUS_BALL_NUMBER = "보너스 볼을 입력해 주세요.";
  private static final Scanner scanner = new Scanner(System.in);
  private static final PrintStream printStream = System.out;

  public static int requestPurchaseAmount() {
    printStream.println(REQUEST_PURCHASE_AMOUNT);
    return scanner.nextInt();
  }

  public static String requestLastWeekWinNumbers() {
    printStream.println(REQUEST_WIN_NUMBERS);
    return scanner.next();
  }

  public static String requestBonusBallNumber() {
    printStream.println(REQUEST_BONUS_BALL_NUMBER);
    return scanner.next();
  }

  public static int requestManualPurchaseLotto() {
    printStream.println(REQUEST_MANUAL_PURCHASE_LOTTO);
    return scanner.nextInt();
  }

  public static List<String> requestManualLottoNumber(int count) {
    printStream.println(REQUEST_MANUAL_LOTTO_NUMBER);
    List<String> list = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      list.add(scanner.next());
    }
    return list;
  }
}
