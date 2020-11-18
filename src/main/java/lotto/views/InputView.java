package lotto.views;

import static lotto.LottoGameConstant.PURCHASE_MESSAGE;
import static lotto.LottoGameConstant.WINNING_NUMBER_MESSAGE;

import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static int askBudget() {
    System.out.println(PURCHASE_MESSAGE);
    return scanner.nextInt();
  }

  public static String askWinningNumber() {
    System.out.println(WINNING_NUMBER_MESSAGE);
    return scanner.next();
  }
}
