package lotto.view;

import static lotto.domain.LottoGames.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.LottoGame;
import lotto.domain.WinningLottoGame;

public class InputView {

  private static final String DELIMITER = ", ";
  private static final String BONUS_BALL_QUESTION = "보너스 볼을 입력해 주세요.";
  private static final String LAST_WEEK_RESULT_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String MANUAL_COUNT_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요.";
  private static final String MANUAL_LOTTO_NUMBERS_QUESTION = "수동으로 구매할 번호를 입력해 주세요.";
  private static final String PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";

  private Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  //-----------------------------------------------------------------------

  public List<LottoGame> buyManualGames() {
    int manualCount = askManualCount();

    printWithNewLine(MANUAL_LOTTO_NUMBERS_QUESTION);
    List<LottoGame> manualGames = new ArrayList<>();
    for (int i = 0; i < manualCount; i++) {
      LottoGame manualGame = buyOneGame();
      manualGames.add(manualGame);
    }

    return manualGames;
  }

  private int askManualCount() {
    printWithNewLine(MANUAL_COUNT_QUESTION);
    return Integer.parseInt(scanner.nextLine());
  }

  private LottoGame buyOneGame() {
    String manualNumbers = scanner.nextLine();
    Set<Integer> manuals = Arrays.stream(manualNumbers.split(DELIMITER))
        .mapToInt(Integer::parseInt)
        .boxed()
        .collect(Collectors.toSet());
    return new LottoGame(manuals);
  }

  //-----------------------------------------------------------------------

  public int payMoney() {
    System.out.println(PURCHASE_AMOUNT_QUESTION);
    int purchaseAmount = Integer.parseInt(scanner.nextLine());

    if (purchaseAmount < LOTTO_PRICE) {
      throw new IllegalArgumentException("최소 1,000원 이상 구입해야 합니다.");
    }

    return purchaseAmount;
  }

  //-----------------------------------------------------------------------

  public WinningLottoGame askWinningLottoGame() {
    Set<Integer> winningNumbers = askWinningNumbers();
    int bonus = askBonusBall();

    return new WinningLottoGame(winningNumbers, bonus);
  }

  private Set<Integer> askWinningNumbers() {
    printWithNewLine(LAST_WEEK_RESULT_QUESTION);
    String lastWinningNumbers = scanner.nextLine();
    return Arrays.stream(lastWinningNumbers.split(DELIMITER))
        .mapToInt(Integer::parseInt)
        .boxed()
        .collect(Collectors.toSet());
  }

  private int askBonusBall() {
    printWithNewLine(BONUS_BALL_QUESTION);
    return Integer.parseInt(scanner.nextLine());
  }

  private void printWithNewLine(String sentence) {
    System.out.println();
    System.out.println(sentence);
  }
}
