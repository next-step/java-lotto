package lotto.step2.view;

import java.util.Scanner;

public class InputView {

  private static InputView instance;
  private final Scanner scanner;

  private InputView () {
    this.scanner = new Scanner(System.in);
  }

  public long inputPrice () {
    System.out.println("구입금액을 입력해 주세요.");
    return Long.parseLong(scanner.nextLine());
  }

  public String inputWinning () {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return scanner.nextLine();
  }

  public static InputView getInstance () {
    if (instance == null) instance = new InputView();
    return instance;
  }
}
