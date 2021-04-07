package step4.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
  private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
  private static final String INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
  private static final String INPUT_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
  private static final String LINE_SPLITTER = System.lineSeparator();

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static Long starting() {
    CommonView.println(INPUT_MESSAGE);
    Long money = scanner.nextLong();
    CommonView.print(LINE_SPLITTER);
    return money;
  }

  public static int saveManualProducts() {
    CommonView.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
    int manualCount = scanner.nextInt();
    CommonView.print(LINE_SPLITTER);
    return manualCount;
  }

  public static List<String> saveManualLottoNumbers(int manualCount) {
    scanner.nextLine();
    CommonView.println(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);

    List<String> consumerPutLottoNumbers = new ArrayList<>();
    for (int i = 0; i < manualCount; i++) {
      consumerPutLottoNumbers.add(scanner.nextLine());
    }

    CommonView.print(LINE_SPLITTER);
    return consumerPutLottoNumbers;
  }

  public static String saveLottoNumbers() {
    CommonView.println(INPUT_LOTTO_MESSAGE);
    String line = scanner.nextLine();
    return line;
  }

  public static int saveBonusBall() {
    CommonView.println(INPUT_BONUS_BALL_MESSAGE);
    int bonusBall = scanner.nextInt();
    CommonView.print(LINE_SPLITTER);
    return bonusBall;
  }
}
