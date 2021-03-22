package lotto.view;

import java.util.Scanner;

public class InputView {

  public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
  private static final Scanner scanner = new Scanner(System.in);
  public static final String INPUT_WINNER_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

  public static int inputMoney() {
    System.out.println(INPUT_MONEY);
    return Integer.parseInt(scanner.nextLine());
  }

  public static String inputWinnerNumber() {
    System.out.println(INPUT_WINNER_NUMBER);
    return scanner.nextLine();
  }

}
