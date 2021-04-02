package lotto.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Money;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.WinningLotto;
import lotto.exception.LottoException;

public final class InputView {

  private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
  private static final String INPUT_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해주세요.";
  private static final String SPACE_REGEX = "\\s";
  private static final String EMPTY_STRING = "";
  private static final String DELIMITER = ",";
  private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해주세요.";
  private static final String INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해주세요.";
  private static final String INPUT_MANUAL_NUMBER = "수동으로 구매할 로또 번호를 입력해주세요.";
  private static final String NOT_A_NUMBER_FORMAT = "정상적인 숫자를 입력해주세요.";

  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public List<Lotto> inputManualLottoNumber(LottoCount manualCount) {
    System.out.println(INPUT_MANUAL_NUMBER);
    List<Lotto> manualLottoList = new ArrayList<>();

    for (int i = 0; i < manualCount.toInteger(); i++) {
      manualLottoList.add(new Lotto(splitNumbers(scanner.nextLine())));
    }
    return manualLottoList;
  }

  public Money inputMoney() {
    while (true) {
      try {
        System.out.println(INPUT_MONEY);
        return new Money(inputLong());
      } catch (LottoException e) {
        System.err.println(e.getMessage());
      }
    }
  }

  public LottoCount inputManualCount() {
    while (true) {
      try {
        System.out.println(INPUT_MANUAL_COUNT);
        return new LottoCount(inputLong());
      } catch (LottoException e) {
        System.err.println(e.getMessage());
      }
    }
  }

  private long inputLong() {
    try {
      return Long.parseLong(scanner.nextLine());
    } catch (NumberFormatException e) {
      throw new LottoException(NOT_A_NUMBER_FORMAT);
    }
  }

  public WinningLotto inputWinningLotto() {
    Lotto lastWinningLotto = inputLastWinningLotto();
    LottoNumber bonusNumber = inputBonusNumber();

    return new WinningLotto(lastWinningLotto, bonusNumber);
  }

  private Lotto inputLastWinningLotto() {
    System.out.println(INPUT_LAST_WEEK_WINNING_NUMBER);
    String winningNumberString = scanner.nextLine();

    String[] winningNumbers = splitNumbers(winningNumberString);
    return new Lotto(winningNumbers);
  }

  private String[] splitNumbers(String numberString) {
    return numberString.replaceAll(SPACE_REGEX, EMPTY_STRING).split(DELIMITER);
  }

  private LottoNumber inputBonusNumber() {
    System.out.println(INPUT_BONUS_NUMBER);
    String bonusNumberString = scanner.nextLine();

    System.out.println();
    return LottoNumber.valueOf(bonusNumberString);
  }
}
