package step2.view;

import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);
  private static final String BUYING_AMOUNT_STR = "구입 금액을 입력해 주세요";
  private static final String WINNING_NUMBER_STR = "지난 주 당첨 번호를 입력해 주세요.";

  public static String getLottoPrice() {
    System.out.println(BUYING_AMOUNT_STR);
    return scanner.nextLine();
  }

  public static String getWinningNumbers() {
    System.out.println(WINNING_NUMBER_STR);
    return scanner.nextLine();
  }

}
