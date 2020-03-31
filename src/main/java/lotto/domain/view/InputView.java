package lotto.domain.view;

import java.util.Scanner;

public class InputView {

  private static final String BONUS_BALL_QUESTION = "보너스 볼을 입력해 주세요.";
  private static final String LAST_WEEK_RESULT_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";

  private Scanner scanner;

  private InputView() {
    scanner = new Scanner(System.in);
  }

  public int getBonusBall() {
    System.out.println(BONUS_BALL_QUESTION);
    return Integer.parseInt(scanner.nextLine());
  }

  public int getPurchaseAmount() {
    System.out.println(PURCHASE_AMOUNT_QUESTION);
    return Integer.parseInt(scanner.nextLine());
  }

  public String getLastWinningNumbers() {
    System.out.println(LAST_WEEK_RESULT_QUESTION);
    return scanner.nextLine();
  }
}
