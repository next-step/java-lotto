package lotto.ui;

import lotto.domain.LottoGame;
import lotto.domain.PurchaseAction;
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

  public LottoGame inputLastWeekWinNumber() {
    return new LottoGame(validatePrice(lastWeekWinNumber()));
  }

  private Optional<Integer> purchasingPrice() {
    return Optional.of(queryAndGetInt(PLEASE_INPUT_PURCHASING_PRICE));
  }

  private Optional<String[]> lastWeekWinNumber() {
    return Optional.of(queryAndGetArray(PLEASE_INPUT_LAST_WEEK_PRIZE));
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
