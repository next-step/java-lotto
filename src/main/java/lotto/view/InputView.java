package lotto.view;

import java.util.Scanner;

public class InputView {

  private static final String INPUT_PURCHASED_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
  private static final String INPUT_LAST_WEEK_WINNING_LOTTO_NUMBERS_PROMPT = "지난 주 당첨 번호를 입력해 주세요.";

  private static final Scanner SCANNER = new Scanner(System.in);

  public static String inputPurchasedAmount() {
    System.out.println(INPUT_PURCHASED_AMOUNT_PROMPT);
    return SCANNER.nextLine();
  }

  public static String inputLastWeekWinningLotto() {
    System.out.println(INPUT_LAST_WEEK_WINNING_LOTTO_NUMBERS_PROMPT);
    return SCANNER.nextLine();
  }
}
