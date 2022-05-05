package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import lotto.domain.LottoGame;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.UserInputFailException;

public class LottoGameInputView {

  private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String PURCHASE_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
  private static final String WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
  private static final String MANUAL_AMOUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
  private static final String MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
  private int purchaseAmount;
  private int manualAmount;
  private List<String> manualNumbers;
  private String winNumbers;
  private String bonusBallNumber;
  private final Scanner scanner;

  public LottoGameInputView() {
    this.scanner = new Scanner(System.in);
    this.manualNumbers = new ArrayList<>();
  }

  private String nextLine() {
    try {
      return scanner.nextLine();
    } catch (NoSuchElementException | IllegalStateException e) {
      throw new UserInputFailException();
    }
  }

  private int nextInt() {
    try {
      return scanner.nextInt();
    } catch (NoSuchElementException | IllegalStateException e) {
      throw new UserInputFailException();
    }
  }

  public void setPurchaseAmount() {
    System.out.println(PURCHASE_AMOUNT_MESSAGE);
    purchaseAmount = nextInt() / LottoGame.GAME_PRICE;
    if (purchaseAmount == 0) {
      throw new InvalidPurchaseAmountException();
    }
    nextLine();
  }

  public void setWinNumbers() {
    System.out.println(WIN_NUMBER_MESSAGE);
    winNumbers = nextLine();
  }

  public void setBonusBall() {
    System.out.println(BONUS_BALL_MESSAGE);
    bonusBallNumber = nextLine();
  }

  public void setManualAmount() {
    System.out.println(MANUAL_AMOUNT_MESSAGE);
    manualAmount = nextInt();
    nextLine();
  }

  public void setManualNumbers() {
    System.out.println(MANUAL_NUMBERS_MESSAGE);
    for (int i = 0; i < manualAmount; i++) {
      manualNumbers.add(nextLine());
    }
  }

  public String getWinNumbers() {
    return winNumbers;
  }

  public String getBonusBallNumber() {
    return bonusBallNumber;
  }

  public int getAutoAmount() {
    return purchaseAmount - manualAmount;
  }

  public int getManualAmount() {
    return manualAmount;
  }

  public List<String> getManualNumbers() {
    return manualNumbers;
  }
}
