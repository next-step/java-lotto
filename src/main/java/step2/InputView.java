package step2;

import java.util.Scanner;

public class InputView {

  public int inputAmount() throws IllegalArgumentException {
    System.out.println("구입금액을 입력해 주세요.");
    Scanner scanner = new Scanner(System.in);
    int returnValue = scanner.nextInt();
    return returnValue;
  }

  public String inputLottoWinnerNumber() throws IllegalArgumentException {
    System.out.println("");
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    Scanner scanner = new Scanner(System.in);
    String returnValue = scanner.nextLine();
    return returnValue;
  }

}
