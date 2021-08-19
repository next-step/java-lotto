package step2.view;

import java.util.Scanner;

public class InputView {

  private final static String COMMA = ",";

  private Scanner scanner = new Scanner(System.in);

  public int inputUserAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    return scanner.nextInt();
  }

  public String[] inputLottoWinningNumber() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return scanner.next().split(COMMA);
  }
}
