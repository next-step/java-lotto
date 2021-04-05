package step3.view;

import java.util.Scanner;

public class InputView {
  private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String INPUT_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static Long starting() {
    CommonView.println(INPUT_MESSAGE);

    return scanner.nextLong();
  }

  public static String saveLottoNumbers() {
    scanner.nextLine();
    CommonView.println(INPUT_LOTTO_MESSAGE);
    return scanner.nextLine();
  }

  public static int saveBonusBall() {
    CommonView.println(INPUT_BONUS_BALL_MESSAGE);
    return scanner.nextInt();
  }
}
