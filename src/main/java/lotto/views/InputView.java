package lotto.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final String PURCHASE_MESSAGE = "구매금액을 입력해 주세요.";
  private static final String NUM_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요";
  private static final String LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
  private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static int askBudget() {
    System.out.println(PURCHASE_MESSAGE);
    return scanner.nextInt();
  }

  public static String askWinningNumber() {
    System.out.println(WINNING_NUMBER_MESSAGE);
    return scanner.nextLine();
  }

  public static int askBonusNumber() {
    System.out.println(BONUS_NUMBER_MESSAGE);
    return scanner.nextInt();
  }

  public static int askNumManualLotto() {
    System.out.println(NUM_MANUAL_LOTTO_MESSAGE);
    return scanner.nextInt();
  }

  public static List<String> askManualLottoNumbers(int numAsk) {
    System.out.println(LOTTO_NUMBERS_MESSAGE);
    List<String> rawInputs = new ArrayList<>();
    scanner.nextLine();
    for (int i = 0; i < numAsk; i++) {
      rawInputs.add(scanner.nextLine());
    }

    return rawInputs;
  }
}
