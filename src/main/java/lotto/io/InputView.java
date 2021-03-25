package lotto.io;

import java.util.Scanner;
import lotto.domain.Lotto;

public final class InputView {

  private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
  private static final String INPUT_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해주세요.";
  private static final String SPACE_REGEX = "\\s";
  private static final String EMPTY_STRING = "";
  private static final String DELIMITER = ",";

  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public int inputMoney() {
    System.out.println(INPUT_MONEY);
    return Integer.parseInt(scanner.nextLine());
  }

  public Lotto inputLastWinningNumber() {
    System.out.println(INPUT_LAST_WEEK_WINNING_NUMBER);
    String winningNumberString = scanner.nextLine();

    String[] winningNumbers = winningNumberString.replaceAll(SPACE_REGEX, EMPTY_STRING).split(DELIMITER);
    System.out.println();
    return new Lotto(winningNumbers);
  }
}
