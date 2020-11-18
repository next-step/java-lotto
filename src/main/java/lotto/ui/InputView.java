package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAction;
import lotto.domain.WinnerLotto;
import lotto.domain.model.LottoNumber;
import lotto.exception.LottoGameException;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import static lotto.constants.Message.*;
import static lotto.utils.StringUtils.splitByComa;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public PurchaseAction orderLottoGame() {
    return new PurchaseAction(validatePrice(purchasingPrice()));
  }

  public WinnerLotto inputLastWeekWinNumber() {
    Lotto prizeLotto = new Lotto(validatePrice(lastWeekWinNumber()));
    LottoNumber bonusNumber = new LottoNumber(validatePrice(bonusNumber()));
    return new WinnerLotto(prizeLotto, bonusNumber);
  }

  private Optional<Integer> purchasingPrice() {
    return Optional.of(queryAndGetInt(PLEASE_INPUT_PURCHASING_PRICE));
  }

  private Optional<String[]> lastWeekWinNumber() {
    return Optional.of(queryAndGetArray(PLEASE_INPUT_LAST_WEEK_PRIZE));
  }

  private Optional<Integer> bonusNumber() {
    return Optional.of(queryAndGetInt(INPUT_BONUS_NUMBER));
  }

  private <T> T validatePrice(Optional<T> purchasingPrice) {
    return purchasingPrice.orElseThrow(() -> new LottoGameException(INPUT_VALUE));
  }

  private Integer queryAndGetInt(String query) {
    System.out.println(query);
    try {
      return SCANNER.nextInt();
    } catch (InputMismatchException e) {
      throw new IllegalArgumentException(INPUT_SHOULD_INTEGER);
    } finally {
      SCANNER.nextLine();
    }
  }

  private String[] queryAndGetArray(String query) {
    System.out.println(query);
    String lastWinNumberInput = SCANNER.nextLine();
    return splitByComa(lastWinNumberInput);
  }
}
