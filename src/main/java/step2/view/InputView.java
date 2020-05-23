package step2.view;

import java.util.Scanner;

public class InputView {

  public static InputView instance;
  public final Scanner scanner = new Scanner(System.in);

  private InputView () { }

  public int inputPrice () {
    System.out.println("구입금액을 입력해 주세요.");
    return Integer.parseInt(scanner.nextLine());
  }

  public String[] inputWinning () {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return scanner.nextLine().split(", ");
  }

  public static InputView getInstance () {
    if (instance != null) instance = new InputView();
    return instance;
  }
}
