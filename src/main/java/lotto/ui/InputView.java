package lotto.ui;

import java.io.PrintStream;
import java.util.Scanner;

public class InputView {

  private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
  private static final String REQUEST_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
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
}
