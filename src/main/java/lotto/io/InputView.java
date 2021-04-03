package lotto.io;

import java.util.Scanner;
import lotto.exception.LottoException;

public final class InputView {

  public static final String NOT_A_NUMBER_FORMAT = "정상적인 숫자를 입력해주세요.";
  private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
  private static final String INPUT_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해주세요.";
  private static final String SPACE_REGEX = "\\s";
  private static final String EMPTY_STRING = "";
  private static final String DELIMITER = ",";
  private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해주세요.";
  private static final String INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해주세요.";
  private static final String INPUT_MANUAL_NUMBER = "수동으로 구매할 로또 번호를 입력해주세요.";

  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public long inputMoney() {
    System.out.println(INPUT_MONEY);
    return inputLong();
  }

  public long inputManualCount() {
    System.out.println(INPUT_MANUAL_COUNT);
    return inputLong();
  }

  private long inputLong() {
    try {
      return Long.parseLong(scanner.nextLine());
    } catch (NumberFormatException e) {
      throw new LottoException(NOT_A_NUMBER_FORMAT);
    }
  }

  public String[] inputManualLotto() {
    return inputLottoNumbers(INPUT_MANUAL_NUMBER);
  }

  public String[] inputWinningNumberLotto() {
    return inputLottoNumbers(INPUT_LAST_WEEK_WINNING_NUMBER);
  }

  public String[] inputLottoNumbers(String message) {
    System.out.println(message);
    return splitNumbers(scanner.nextLine());
  }

  private String[] splitNumbers(String numberString) {
    return numberString.replaceAll(SPACE_REGEX, EMPTY_STRING).split(DELIMITER);
  }

  public String inputBonusNumber() {
    System.out.println(INPUT_BONUS_NUMBER);
    String bonusNumberString = scanner.nextLine();
    Printer.printBlankLine();
    return bonusNumberString;
  }
}
