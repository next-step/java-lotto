package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAction;
import lotto.domain.WinnerLotto;
import lotto.domain.model.LottoNumber;
import lotto.exception.LottoGameException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constants.Message.*;
import static lotto.utils.StringUtils.splitByComa;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final int ZERO = 0;
  private static final int INC = 1;

  public PurchaseAction orderLottoGame() {
    Integer price = validatePrice(purchasingPrice());
    Integer manualLottoGameCount = validatePrice(manualLottoGameCount());
    List<String[]> manualLottoGameNumbers = validatePrice(manualLottoGameNumbers(manualLottoGameCount));
    return new PurchaseAction(price, manualLottoGameNumbers);
  }

  private Optional<List<String[]>> manualLottoGameNumbers(Integer manualLottoGameCount) {
    return Optional.of(queryAndManualNumberToLimit(PLEASE_INPUT_MANUAL_NUMBER, manualLottoGameCount));
  }

  private Optional<Integer> manualLottoGameCount() {
    return Optional.of(queryAndGetInt(PLEASE_INPUT_MANUAL_PURCHASE_COUNT));
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


  private List<String[]> queryAndManualNumberToLimit(String query, Integer limit) {
    if (limit <= ZERO) {
      return Collections.EMPTY_LIST;
    }
    System.out.println(query);
    return Stream.iterate(ZERO, integer -> integer + INC)
        .limit(limit)
        .map(integer -> splitByComa(SCANNER.nextLine()))
        .collect(Collectors.toList());
  }
}
