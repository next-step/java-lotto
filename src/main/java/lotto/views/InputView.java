package lotto.views;

import java.util.Scanner;

public class InputView {

  private static final String PURCHASE_MESSAGE = "구매금액을 입력해 주세요.";
  public static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static int askBudget() {
    System.out.println(PURCHASE_MESSAGE);
    return scanner.nextInt();
  }

  public static String askWinningNumber() {
    System.out.println(WINNING_NUMBER_MESSAGE);
    scanner.nextLine();
    return scanner.nextLine();
  }
}
