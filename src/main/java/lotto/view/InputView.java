package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
  private static final String DELIMITER = ", ";
  private static final String INPUT_WINNER_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
  private static final Scanner scanner = new Scanner(System.in);

  public static int inputMoney() {
    System.out.println(INPUT_MONEY);
    return Integer.parseInt(scanner.nextLine());
  }

  public static List<Integer> inputWinnerNumber() {
    System.out.println(INPUT_WINNER_NUMBER);
    String winnerNumberString = scanner.nextLine();
    String[] split = winnerNumberString.split(DELIMITER);
    List<Integer> winnerNumber = new ArrayList<>();
    for (String string : split) {
      int number = Integer.parseInt(string);
      winnerNumber.add(number);
    }
    return winnerNumber;
  }

  public static int inputBonusNumber() {
    System.out.println(INPUT_BONUS_NUMBER);
    return Integer.parseInt(scanner.nextLine());
  }
}
