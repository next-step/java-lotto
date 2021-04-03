package step3.view;

import java.util.Scanner;

public class InputView {
  private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String INPUT_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final int LOTTO_STANDARD_SIZE = 6;

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static int starting() {
    CommonView.println(INPUT_MESSAGE);

    return scanner.nextInt();
  }

  public static String saveLottoNumbers() {
    scanner.nextLine();
    CommonView.println(INPUT_LOTTO_MESSAGE);
    return scanner.nextLine();
  }
}
