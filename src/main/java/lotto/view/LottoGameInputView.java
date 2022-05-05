package lotto.view;

import java.util.NoSuchElementException;
import java.util.Scanner;
import lotto.domain.LottoGame;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.UserInputFailException;

public class LottoGameInputView {

  private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String PURCHASE_COUNT_MESSAGE = "%d 개를 구매했습니다.\n";
  private static final String WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
  private int purchaseAmount;
  private String winNumbers;
  private String bonusBallNumber;
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

  public void setWinNumbers() {
    System.out.println(WIN_NUMBER_MESSAGE);
    try {
      inputWinNumbers();
    } catch (NoSuchElementException | IllegalStateException e) {
      throw new UserInputFailException();
    }
  }

  public void setBonusBall() {
    System.out.println(BONUS_BALL_MESSAGE);
    try {
      inputBonusBall();
    } catch (NoSuchElementException | IllegalStateException e) {
      throw new UserInputFailException();
    }
  }

  private void inputBonusBall() {
    bonusBallNumber = scanner.nextLine();
  }

  public int getPurchaseAmount() {
    return purchaseAmount;
  }

  public String getWinNumbers() {
    return winNumbers;
  }

  private void inputWinNumbers() {
    winNumbers = scanner.nextLine();
  }

  private void inputPurchaseAmount() {
    purchaseAmount = scanner.nextInt() / LottoGame.GAME_PRICE;
    if (purchaseAmount == 0) {
      throw new InvalidPurchaseAmountException();
    }
    scanner.nextLine();
  }

  public String getBonusBallNumber() {
    return bonusBallNumber;
  }
}
