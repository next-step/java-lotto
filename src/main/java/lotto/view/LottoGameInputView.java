package lotto.view;

import calculator.exception.UserInputFailException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LottoGameInputView {

  private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String PURCHASE_COUNT_MESSAGE = "%d 개를 구매했습니다.\n";
  private static final String WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String LOTTO_STATS_MESSAGE = "당첨 통계";
  private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %d 입니다.";
  private int purchaseAmount;
  private String winNumbers;
  private final Scanner scanner;

  public LottoGameInputView() {
    this.scanner = new Scanner(System.in);
  }

  public void setPurchaseAmount() {
    System.out.println(PURCHASE_AMOUNT_MESSAGE);

    try {
      inputPurchaseAmount();
    } catch (NoSuchElementException | IllegalStateException e) {
      throw new UserInputFailException();
    }

    System.out.printf(PURCHASE_COUNT_MESSAGE, purchaseAmount);

  }

  private void inputPurchaseAmount() {
    purchaseAmount = scanner.nextInt();
    scanner.nextLine();
  }

  public void printLottoGames() {

  }

  public void setWinNumbers() {
    System.out.println(WIN_NUMBER_MESSAGE);
    try {
      inputWinNumbers();
    } catch (NoSuchElementException | IllegalStateException e) {
      throw new UserInputFailException();
    }
  }

  private void inputWinNumbers() {
    winNumbers = scanner.nextLine();
  }

  public void printGameStats() {
    System.out.println(LOTTO_STATS_MESSAGE);
    System.out.println("---------");
    System.out.println(PROFIT_RATE_MESSAGE);
  }

  public int getPurchaseAmount() {
    return purchaseAmount;
  }

  public String getWinNumbers() {
    return winNumbers;
  }
}
